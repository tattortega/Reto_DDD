package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AgregarInspeccion;
import co.com.sofkau.taller.mecanico.events.InspeccionAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.values.Diagnostico;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

/**
 * Test para el caso de uso agregar Inspeccion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class AgregarInspeccionUseCaseTest {

    @InjectMocks
    AgregarInspeccionUseCase agregarInspeccionUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarInspeccionUseCase() {
        var inspeccionId = InspeccionId.of("33253");
        var mecanicoId = MecanicoId.of("054");
        var diagnostico = new Diagnostico("La bateria hizo corto circuito");
        Set<ListaRepuestos> listaRepuestos = new HashSet<>();
        var repuesto1 = new ListaRepuestos("Bateria Mac Silver 36IST750MC");
        listaRepuestos.add(repuesto1);
        var command = new AgregarInspeccion(inspeccionId, mecanicoId, diagnostico, listaRepuestos);

        when(repository.getEventsBy("054")).thenReturn(history());
        agregarInspeccionUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.mecanicoId().value())
                .syncExecutor(agregarInspeccionUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InspeccionAgregada) events.get(0);
        Assertions.assertEquals("La bateria hizo corto circuito",
                event.diagnostico().value());
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