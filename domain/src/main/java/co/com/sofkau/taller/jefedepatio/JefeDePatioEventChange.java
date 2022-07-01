package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.jefedepatio.entities.Registro;
import co.com.sofkau.taller.jefedepatio.events.AutoAgregado;
import co.com.sofkau.taller.jefedepatio.events.ClienteAgregado;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.events.RegistroExitoso;

import java.util.HashMap;

public class JefeDePatioEventChange extends EventChange {

    public JefeDePatioEventChange(JefeDePatio jefeDePatio) {
        apply((JefeDePatioAsignado event) -> {
            jefeDePatio.nombre = event.nombre();
            jefeDePatio.telefono = event.telefono();
            jefeDePatio.correo = event.correo();
            jefeDePatio.mecanicoId = event.mecanicoId();
            jefeDePatio.vendedorId = event.vendedorId();
            jefeDePatio.auto = new HashMap<>();
            jefeDePatio.cliente = new HashMap<>();
            jefeDePatio.registro = new HashMap<>();
        });

        apply((AutoAgregado event) -> {
            var autoId = event.autoId();
            var auto = new Auto(autoId, event.marca(), event.placa());
            jefeDePatio.auto.put(autoId, auto);
        });

        apply((ClienteAgregado event) -> {
            var clienteId = event.clienteId();
            var cliente = new Cliente(clienteId, event.documento(), event.nombre(),
                    event.telefono(), event.correo());
            jefeDePatio.cliente.put(clienteId, cliente);
        });

        apply((RegistroExitoso event) -> {
            var registroId = event.registroId();
            var registro = new Registro(registroId, event.tipoDeTrabajo(), event.ingreso(),
                    event.autorizacionCliente(), event.cliente(), event.auto());
            jefeDePatio.registro.put(registroId, registro);
        });
    }
}
