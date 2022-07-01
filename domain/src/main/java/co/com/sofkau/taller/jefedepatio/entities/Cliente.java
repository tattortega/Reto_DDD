package co.com.sofkau.taller.jefedepatio.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Documento;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;

/**
 * Entidad Cliente con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Cliente extends Entity<ClienteId> {

    protected Documento documento;
    protected Nombre nombre;
    protected Telefono telefono;
    protected Correo correo;

    public Cliente(ClienteId entityId, Documento documento, Nombre nombre, Telefono telefono, Correo correo) {
        super(entityId);
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Documento documento() {
        return documento;
    }

    public void agregarDocumento(Documento documento) {
        this.documento = documento;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void agregarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public void agregarTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Correo correo() {
        return correo;
    }

    public void agregarCorreo(Correo correo) {
        this.correo = correo;
    }
}
