package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.Set;


public class VendedorAsignado extends DomainEvent {
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final transient Set<Cliente> clientes;
    private final transient Set<Auto> autos;
    private final Set<ListaRepuestos> listaRepuestos;

    public VendedorAsignado(VendedorId vendedorId, Nombre nombre, Telefono telefono, Correo correo,
                            Set<Cliente> clientes, Set<Auto> autos, Set<ListaRepuestos> listaRepuestos) {
        super("co.com.sofkau.taller.VendedorAsignado");
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.clientes = clientes;
        this.autos = autos;
        this.listaRepuestos = listaRepuestos;
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

    public Set<Cliente> clientes() {
        return clientes;
    }

    public Set<Auto> autos() {
        return autos;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }
}
