package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.commands.AgregarAuto;
import co.com.sofkau.taller.jefedepatio.events.AutoAgregado;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.jefedepatio.values.Marca;
import co.com.sofkau.taller.jefedepatio.values.Placa;
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
class AgregarAutoUseCaseTest {

    @InjectMocks
    AgregarAutoUseCase agregarAutoUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarAuto() {
        var autoId = AutoId.of("11");
        var jefeDePatioId = JefeDePatioId.of("01");
        var marca = new Marca("Mazda");
        var placa = new Placa("ZKY127");
        var command = new AgregarAuto(autoId, jefeDePatioId, marca, placa);

        when(repository.getEventsBy("01")).thenReturn(history());
        agregarAutoUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.jefeDePatioId().value())
                .syncExecutor(agregarAutoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AutoAgregado) events.get(0);
        Assertions.assertEquals("Mazda", event.marca().value());
        Assertions.assertEquals("ZKY127", event.placa().value());
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