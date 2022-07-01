package co.com.sofkau.taller.jefedepatio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Documento;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;

/**
 * Comando para agregar Cliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarCliente extends Command {
    private final ClienteId clienteId;
    private final JefeDePatioId jefeDePatioId;
    private final Documento documento;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;

    public AgregarCliente(ClienteId clienteId, JefeDePatioId jefeDePatioId, Documento documento,
                          Nombre nombre, Telefono telefono, Correo correo) {
        this.clienteId = clienteId;
        this.jefeDePatioId = jefeDePatioId;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public JefeDePatioId jefeDePatioId() {
        return jefeDePatioId;
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public Documento documento() {
        return documento;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Correo correo() {
        return correo;
    }
}
