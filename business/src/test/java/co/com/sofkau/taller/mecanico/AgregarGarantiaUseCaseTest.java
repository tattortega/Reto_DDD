package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AgregarGarantia;
import co.com.sofkau.taller.mecanico.events.GarantiaAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.values.GarantiaId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.*;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Test para el caso de uso agregar Garantia
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class AgregarGarantiaUseCaseTest {

    @InjectMocks
    AgregarGarantiaUseCase agregarGarantiaUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarGarantia() {
        var garantiaId = GarantiaId.of("23");
        var mecanicoId = MecanicoId.of("054");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.GARANTIA);
        var estados = new Estado(Estado.Estados.EMPEZADO);
        var observacion = new Observacion("La bateria del auto se descarga rapido");
        var command = new AgregarGarantia(garantiaId, mecanicoId, tipoDeTrabajo, estados, observacion);

        when(repository.getEventsBy("054")).thenReturn(history());
        agregarGarantiaUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.mecanicoId().value())
                .syncExecutor(agregarGarantiaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (GarantiaAgregada) events.get(0);
        Assertions.assertEquals(TipoDeTrabajo.Tipos.GARANTIA,
                event.tipoDeTrabajo().value());

    }

    private List<DomainEvent> history() {
        var vendedorId = VendedorId.of("03");
        var registroId = RegistroId.of("452");
        var nombre = new Nombre("Manuel");
        var telefono = new Telefono("52365422");
        var correo = new Correo("manuel@chevrocentro.com");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.GARANTIA);
        var event = new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoDeTrabajo);
        event.setAggregateRootId("054");
        return List.of(event);
    }
}