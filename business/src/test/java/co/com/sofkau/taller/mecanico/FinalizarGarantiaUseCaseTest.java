package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.commands.FinalizarGarantia;
import co.com.sofkau.taller.mecanico.events.GarantiaAgregada;
import co.com.sofkau.taller.mecanico.events.GarantiaFinalizada;
import co.com.sofkau.taller.mecanico.events.InspeccionAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.values.*;
import co.com.sofkau.taller.valuesgeneric.*;
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

@ExtendWith(MockitoExtension.class)
class FinalizarGarantiaUseCaseTest {

    @InjectMocks
    FinalizarGarantiaUseCase finalizarGarantiaUseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void finalizarGarantia() {
        var vendedorId = VendedorId.of("03");
        var mecanicoId = MecanicoId.of("054");
        var registroId = RegistroId.of("452");
        var garantiaId = GarantiaId.of("23");
        var inspeccionId = InspeccionId.of("33253");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.GARANTIA);
        var estados = new Estado(Estado.Estados.EMPEZADO);
        var observacion = new Observacion("Se debe cambiar la bateria por otra");
        var command = new FinalizarGarantia(vendedorId, mecanicoId, registroId, garantiaId, inspeccionId,
                tipoDeTrabajo, estados, observacion);

        when(repository.getEventsBy("054")).thenReturn(history());
        finalizarGarantiaUseCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.mecanicoId().value())
                .syncExecutor(finalizarGarantiaUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (GarantiaFinalizada) events.get(0);
        Assertions.assertEquals(Estado.Estados.FINALIZADO, event.estados().value());
    }

    private List<DomainEvent> history() {
        var vendedorId = VendedorId.of("03");
        var registroId = RegistroId.of("452");
        var nombre = new Nombre("Cristian");
        var telefono = new Telefono("3125632563");
        var correo = new Correo("cristian@chevrocentro.com");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.GARANTIA);

        var event = new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoDeTrabajo);

        var inspeccionId = InspeccionId.of("33253");
        var diagnostico = new Diagnostico("La bateria hizo corto circuito");
        Set<ListaRepuestos> listaRepuestos = new HashSet<>();
        var repuesto1 = new ListaRepuestos("Bateria Mac Silver 36IST750MC");
        listaRepuestos.add(repuesto1);

        var event2 = new InspeccionAgregada(inspeccionId, diagnostico, listaRepuestos);

        var garantiaId = GarantiaId.of("23");
        var estados = new Estado(Estado.Estados.EMPEZADO);
        var observacion = new Observacion("Se debe cambiar la bateria por otra");

        var event3 = new GarantiaAgregada(garantiaId, tipoDeTrabajo, estados, observacion);

        event.setAggregateRootId("054");
        return List.of(event, event2, event3);
    }

}