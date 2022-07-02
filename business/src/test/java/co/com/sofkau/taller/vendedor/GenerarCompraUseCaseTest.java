package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.events.CompraGenerada;
import co.com.sofkau.taller.vendedor.values.ValorCompra;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Test para el caso de uso generar Compra
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class GenerarCompraUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private final ValorCompra valorCompra = new ValorCompra(350000);

    @Test
    void generarCompra() {
        var vendedorId = VendedorId.of("03");
        var event = createTriggeredEventWith(vendedorId);
        var useCase = new GenerarCompraUseCase();
        when(repository.getEventsBy(vendedorId.value())).thenReturn(eventStored(vendedorId));
        useCase.addRepository(repository);
        var events = executor(vendedorId, event, useCase);
        var compra = (CompraGenerada) events.get(0);
        Assertions.assertEquals(350000, compra.valorCompra().value());
    }

    private CompraGenerada createTriggeredEventWith(VendedorId vendedorId) {
        var event = new CompraGenerada(vendedorId, valorCompra);
        event.setAggregateRootId(vendedorId.value());
        return event;
    }

    private List<DomainEvent> eventStored(VendedorId vendedorId) {
        return List.of(
                new CompraGenerada(vendedorId, valorCompra)
        );
    }

    private List<DomainEvent> executor(VendedorId vendedorId, CompraGenerada event, GenerarCompraUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(vendedorId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }
}
