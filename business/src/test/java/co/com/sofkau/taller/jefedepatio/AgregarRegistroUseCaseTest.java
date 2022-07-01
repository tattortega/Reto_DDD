package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.commands.AgregarRegistro;
import co.com.sofkau.taller.jefedepatio.events.AutoAgregado;
import co.com.sofkau.taller.jefedepatio.events.ClienteAgregado;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.events.RegistroAgregado;
import co.com.sofkau.taller.jefedepatio.values.*;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Test para el caso de uso agregar Registro
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class AgregarRegistroUseCaseTest {

    @InjectMocks
    AgregarRegistroUseCase agregarRegistroUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarRegistro() {
        var registroId = RegistroId.of("452");
        var jefeDePatioId = JefeDePatioId.of("01");
        var clienteId = ClienteId.of("142");
        var autoId = AutoId.of("11");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.REPARACION);
        var ingreso = new Ingreso(LocalDateTime.now(), LocalDate.now());
        var autorizacionCliente = new AutorizacionCliente(AutorizacionCliente.Autorizacion.AUTORIZADO);
        var command = new AgregarRegistro(registroId, jefeDePatioId, clienteId, autoId, tipoDeTrabajo, ingreso,
                autorizacionCliente);

        when(repository.getEventsBy("01")).thenReturn(history());
        agregarRegistroUseCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.jefeDePatioId().value())
                .syncExecutor(agregarRegistroUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RegistroAgregado) events.get(0);
        Assertions.assertEquals(AutorizacionCliente.Autorizacion.AUTORIZADO, event.autorizacionCliente().value());

    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("Jorge");
        var telefono = new Telefono("3158653698");
        var correo = new Correo("jorge@chevrocentro.com");
        var mecanicoId = MecanicoId.of("054");
        var vendedorId = VendedorId.of("03");

        var event = new JefeDePatioAsignado(nombre, telefono, correo, mecanicoId, vendedorId);

        var clienteId = ClienteId.of("142");
        var documento = new Documento("109563625");

        var event2 = new ClienteAgregado(clienteId, documento, nombre, telefono, correo);

        var autoId = AutoId.of("11");
        var marca = new Marca("Mazda");
        var placa = new Placa("ZKY127");

        var event3 = new AutoAgregado(autoId, marca, placa);

        event.setAggregateRootId("01");
        return List.of(event, event2, event3);
    }

}