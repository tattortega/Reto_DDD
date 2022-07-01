package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.taller.jefedepatio.commands.AsignarJefeDePatio;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CrearJefeDePatioUseCaseTest {
    @InjectMocks
    private CrearJefeDePatioUseCase crearJefeDePatioUseCase;


    @Test
    void crearJefeDePatio() {
        var jefeDePatioId = JefeDePatioId.of("01");
        var mecanidoId = MecanicoId.of("054");
        var vendedorId = VendedorId.of("03");
        var nombre = new Nombre("Edgar");
        var correo = new Correo("edgar@chevrocentro.com");
        var telefono = new Telefono("3132568563");
        var command = new AsignarJefeDePatio(jefeDePatioId, mecanidoId, vendedorId, nombre, correo, telefono);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(crearJefeDePatioUseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var jefeDePatioAsignado = (JefeDePatioAsignado) events.get(0);
        Assertions.assertEquals("01", jefeDePatioAsignado.aggregateRootId());
        Assertions.assertEquals("Edgar", jefeDePatioAsignado.nombre().value());
        Assertions.assertEquals("edgar@chevrocentro.com", jefeDePatioAsignado.correo().value());
    }

}