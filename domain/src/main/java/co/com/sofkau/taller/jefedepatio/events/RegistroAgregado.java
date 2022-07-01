package co.com.sofkau.taller.jefedepatio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.AutorizacionCliente;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Ingreso;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.Map;


public class RegistroAgregado extends DomainEvent {
    private final RegistroId registroId;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Ingreso ingreso;
    private final AutorizacionCliente autorizacionCliente;
    private final transient Map<ClienteId, Cliente> cliente;
    private final transient Map<AutoId, Auto> auto;

    public RegistroAgregado(RegistroId registroId, MecanicoId mecanicoId, VendedorId vendedorId,
                            TipoDeTrabajo tipoDeTrabajo, Ingreso ingreso, AutorizacionCliente autorizacionCliente,
                            Map<ClienteId, Cliente> cliente, Map<AutoId, Auto> auto) {
        super("co.com.sofkau.taller.jefedepatio.RegistroExitoso");
        this.registroId = registroId;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.cliente = cliente;
        this.auto = auto;
    }

    public RegistroId registroId() {
        return registroId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public Ingreso ingreso() {
        return ingreso;
    }

    public AutorizacionCliente autorizacionCliente() {
        return autorizacionCliente;
    }

    public Map<ClienteId, Cliente> cliente() {
        return cliente;
    }

    public Map<AutoId, Auto> auto() {
        return auto;
    }
}
