package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.commands.AgregarCliente;
import co.com.sofkau.taller.jefedepatio.events.ClienteAgregado;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Documento;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarClienteUseCaseTest {

    @InjectMocks
    AgregarClienteUseCase agregarClienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarCliente() {
        var clienteId = ClienteId.of("142");
        var jefeDePatioId = JefeDePatioId.of("01");
        var documento = new Documento("109563625");
        var nombre = new Nombre("Raul");
        var telefono = new Telefono("3201523600");
        var correo = new Correo("raul.alzate@sofka.com.co");
        var command = new AgregarCliente(clienteId, jefeDePatioId, documento, nombre, telefono, correo);

        when(repository.getEventsBy("01")).thenReturn(history());
        agregarClienteUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.jefeDePatioId().value())
                .syncExecutor(agregarClienteUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClienteAgregado) events.get(0);
        Assertions.assertEquals("109563625", event.documento().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("Jorge");
        var telefono = new Telefono("3158653698");
        var correo = new Correo("jorge@chevrocentro.com");
        var mecanicoId = MecanicoId.of("054");
        var vendedorId = VendedorId.of("03");

        var event = new JefeDePatioAsignado(nombre, telefono, correo, mecanicoId, vendedorId);
        event.setAggregateRootId("01");
        return List.of(event);
    }
}