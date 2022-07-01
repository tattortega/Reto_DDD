package co.com.sofkau.taller.jefedepatio.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.AutorizacionCliente;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Ingreso;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;

import java.util.Map;

/**
 * Entidad Registro con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Registro extends Entity<RegistroId> {

    protected TipoDeTrabajo tipoDeTrabajo;
    protected Ingreso ingreso;
    protected AutorizacionCliente autorizacionCliente;
    protected Map<ClienteId, Cliente> cliente;
    protected Map<AutoId, Auto> auto;


    public Registro(RegistroId entityId, TipoDeTrabajo tipoDeTrabajo, Ingreso ingreso,
                    AutorizacionCliente autorizacionCliente,
                    Map<ClienteId, Cliente> cliente, Map<AutoId, Auto> auto) {
        super(entityId);
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.ingreso = ingreso;
        this.autorizacionCliente = autorizacionCliente;
        this.cliente = cliente;
        this.auto = auto;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public void agregarTipoDeTrabajo(TipoDeTrabajo tipoDeTrabajo) {
        this.tipoDeTrabajo = tipoDeTrabajo;
    }

    public Ingreso ingreso() {
        return ingreso;
    }

    public void agregarIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public AutorizacionCliente autorizacionCliente() {
        return autorizacionCliente;
    }

    public void agregarAutorizacionCliente(AutorizacionCliente autorizacionCliente) {
        this.autorizacionCliente = autorizacionCliente;
    }

    public Map<ClienteId, Cliente> cliente() {
        return cliente;
    }

    public void agregarCliente(Map<ClienteId, Cliente> cliente) {
        this.cliente = cliente;
    }

    public Map<AutoId, Auto> auto() {
        return auto;
    }

    public void agregarAuto(Map<AutoId, Auto> auto) {
        this.auto = auto;
    }
}
