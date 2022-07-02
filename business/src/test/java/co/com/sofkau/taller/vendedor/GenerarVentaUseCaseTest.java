package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.events.VentaGenerada;
import co.com.sofkau.taller.vendedor.values.*;
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
class GenerarVentaUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    private final ValorReparacion valorReparacion = new ValorReparacion(80000);

    @Test
    void generarVenta() {
        var vendedorId = VendedorId.of("03");
        var event = createTriggeredEventWith(vendedorId);
        var useCase = new GenerarVentaUseCase();
        when(repository.getEventsBy(vendedorId.value())).thenReturn(eventStored(vendedorId));
        useCase.addRepository(repository);
        var events = executor(vendedorId, event, useCase);
        var venta = (VentaGenerada) events.get(0);
        Assertions.assertEquals(80000, venta.valorReparacion().value());
    }

    private VentaGenerada createTriggeredEventWith(VendedorId vendedorId) {
        var tipoDePago = new TipoDePago(TipoDePago.Pago.CONTADO);
        var metodoDePago = new MetodoPago(MetodoPago.Metodo.EFECTIVO);
        var event = new VentaGenerada(vendedorId, tipoDePago, metodoDePago, valorReparacion);

        event.setAggregateRootId(vendedorId.value());
        return event;
    }

    private List<DomainEvent> eventStored(VendedorId vendedorId) {
        var tipoDePago = new TipoDePago(TipoDePago.Pago.CONTADO);
        var metodoDePago = new MetodoPago(MetodoPago.Metodo.EFECTIVO);
        return List.of(
                new VentaGenerada(vendedorId, tipoDePago, metodoDePago, valorReparacion)
        );
    }

    private List<DomainEvent> executor(VendedorId vendedorId, VentaGenerada event, GenerarVentaUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(vendedorId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }
}