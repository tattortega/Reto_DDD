package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class MecanicoAsignado extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final TipoDeTrabajo tipoDeTrabajo;


    public MecanicoAsignado(VendedorId vendedorId, RegistroId registroId, Nombre nombre, Telefono telefono, Correo correo,
                            TipoDeTrabajo tipoDeTrabajo) {
        super("co.com.sofkau.taller.mecanico.MecanicoAgregado");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoDeTrabajo = tipoDeTrabajo;
    }

    public RegistroId registroId() {
        return registroId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
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

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }
}
