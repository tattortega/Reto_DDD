package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AgregarReparacion;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.events.ReparacionAgregada;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
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
 * Test para el caso de uso agregar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class AgregarReparacionUseCaseTest {

    @InjectMocks
    AgregarReparacionUseCase agregarReparacionUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarReparacion() {
        var reparacionId = ReparacionId.of("4522");
        var mecanidoId = MecanicoId.of("054");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.REPARACION);
        var estados = new Estado(Estado.Estados.EMPEZADO);
        var observacion = new Observacion("Se debe cambiar la bateria por otra");
        var command = new AgregarReparacion(reparacionId, mecanidoId, tipoDeTrabajo, estados, observacion);

        when(repository.getEventsBy("054")).thenReturn(history());
        agregarReparacionUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.mecanicoId().value())
                .syncExecutor(agregarReparacionUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ReparacionAgregada) events.get(0);
        Assertions.assertEquals(TipoDeTrabajo.Tipos.REPARACION,
                event.tipoDeTrabajo().value());
    }

    private List<DomainEvent> history() {
        var vendedorId = VendedorId.of("03");
        var registroId = RegistroId.of("452");
        var nombre = new Nombre("Cristian");
        var telefono = new Telefono("3125632563");
        var correo = new Correo("cristian@chevrocentro.com");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.REPARACION);
        var event = new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoDeTrabajo);
        event.setAggregateRootId("054");
        return List.of(event);
    }
}