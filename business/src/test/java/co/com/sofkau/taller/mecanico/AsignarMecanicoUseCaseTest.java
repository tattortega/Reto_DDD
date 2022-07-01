package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.commands.AsignarMecanico;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AsignarMecanicoUseCaseTest {

    @InjectMocks
    private AsignarMecanicoUseCase asignarMecanicoUseCase;

    @Test
    public void asignarMecanico() {
        var vendedorId = VendedorId.of("03");
        var mecanicoId = MecanicoId.of("054");
        var registroId = RegistroId.of("452");
        var nombre = new Nombre("Cristian");
        var telefono = new Telefono("3125632563");
        var correo = new Correo("cristian@chevrocentro.com");
        var tipoDeTrabajo = new TipoDeTrabajo(TipoDeTrabajo.Tipos.REPARACION);
        var command = new AsignarMecanico(vendedorId, mecanicoId, registroId, nombre, telefono, correo, tipoDeTrabajo);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(asignarMecanicoUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var mecanicoAsignado = (MecanicoAsignado) events.get(0);
        Assertions.assertEquals("054", mecanicoAsignado.aggregateRootId());
        Assertions.assertEquals("Cristian", mecanicoAsignado.nombre().value());
        Assertions.assertEquals("3125632563", mecanicoAsignado.telefono().value());
        Assertions.assertEquals("cristian@chevrocentro.com", mecanicoAsignado.correo().value());
    }
}