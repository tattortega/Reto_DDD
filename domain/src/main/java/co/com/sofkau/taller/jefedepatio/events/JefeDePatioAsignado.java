package co.com.sofkau.taller.jefedepatio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class JefeDePatioAsignado extends DomainEvent {
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;


    public JefeDePatioAsignado(Nombre nombre, Telefono telefono, Correo correo, MecanicoId mecanicoId, VendedorId vendedorId) {
        super("co.com.sofkau.taller.jefedepatio.AsesorAsignado");
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
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

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }
}
