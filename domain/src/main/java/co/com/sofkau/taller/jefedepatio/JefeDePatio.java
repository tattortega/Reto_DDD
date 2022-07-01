package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.jefedepatio.entities.Registro;
import co.com.sofkau.taller.jefedepatio.events.AutoAgregado;
import co.com.sofkau.taller.jefedepatio.events.ClienteAgregado;
import co.com.sofkau.taller.jefedepatio.events.JefeDePatioAsignado;
import co.com.sofkau.taller.jefedepatio.events.RegistroAgregado;
import co.com.sofkau.taller.jefedepatio.values.*;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.List;
import java.util.Map;

/**
 * Agregado root para Jefe de patio con sus atributos y comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class JefeDePatio extends AggregateEvent<JefeDePatioId> {

    protected MecanicoId mecanicoId;
    protected VendedorId vendedorId;
    protected Nombre nombre;
    protected Correo correo;
    protected Telefono telefono;
    protected Map<RegistroId, Registro> registro;
    protected Map<ClienteId, Cliente> cliente;
    protected Map<AutoId, Auto> auto;

    private JefeDePatio(JefeDePatioId jefeDePatioId) {
        super(jefeDePatioId);
        subscribe(new JefeDePatioEventChange(this));
    }

    public JefeDePatio(JefeDePatioId jefeDePatioId, MecanicoId mecanicoId, VendedorId vendedorId, Nombre nombre,
                       Correo correo, Telefono telefono) {
        super(jefeDePatioId);
        appendChange(new JefeDePatioAsignado(nombre, telefono, correo, mecanicoId, vendedorId)).apply();
        subscribe(new JefeDePatioEventChange(this));
    }


    public static JefeDePatio from(JefeDePatioId jefeDePatioId, List<DomainEvent> events) {
        var jefeDePatio = new JefeDePatio(jefeDePatioId);
        events.forEach(jefeDePatio::applyEvent);
        return jefeDePatio;
    }

    public void agregarRegistro(TipoDeTrabajo tipoDeTrabajo, Ingreso ingreso, AutorizacionCliente autorizacionCliente) {
        var registroId = new RegistroId();
        appendChange(new RegistroAgregado(registroId, this.mecanicoId, this.vendedorId, tipoDeTrabajo, ingreso,
                autorizacionCliente, this.cliente, this.auto)).apply();
    }

    public void agregarCliente(Documento documento, Nombre nombre, Telefono telefono, Correo correo) {
        var clienteId = new ClienteId();
        appendChange(new ClienteAgregado(clienteId, documento, nombre, telefono, correo)).apply();
    }

    public void agregarAuto(Marca marca, Placa placa) {
        var autoId = new AutoId();
        appendChange(new AutoAgregado(autoId, marca, placa)).apply();
    }

    public MecanicoId mecanicoId() {
        return this.mecanicoId;
    }

    public VendedorId vendedorId() {
        return this.vendedorId;
    }

    public Nombre nombre() {
        return this.nombre;
    }

    public Correo correo() {
        return this.correo;
    }

    public Telefono telefono() {
        return this.telefono;
    }

    public Map<RegistroId, Registro> registro() {
        return this.registro;
    }

    public Map<ClienteId, Cliente> cliente() {
        return this.cliente;
    }

    public Map<AutoId, Auto> auto() {
        return this.auto;
    }
}
