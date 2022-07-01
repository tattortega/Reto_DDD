package co.com.sofkau.taller.jefedepatio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Documento;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;

/**
 * Evento de dominio para agregar Cliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ClienteAgregado extends DomainEvent {
    private final ClienteId clienteId;
    private final Documento documento;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;

    public ClienteAgregado(ClienteId clienteId, Documento documento, Nombre nombre, Telefono telefono, Correo correo) {
        super("co.com.sofkau.taller.jefedepatio.ClienteAgregado");
        this.clienteId = clienteId;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
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
