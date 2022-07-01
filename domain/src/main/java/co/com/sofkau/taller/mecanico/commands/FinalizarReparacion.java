package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;

/**
 * Comando para finalizar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class FinalizarReparacion extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final ReparacionId reparacionId;
    private final InspeccionId inspeccionId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;

    public FinalizarReparacion(VendedorId vendedorId, MecanicoId mecanicoId, RegistroId registroId,
                               ReparacionId reparacionId, InspeccionId inspeccionId,
                               TipoDeTrabajo tipoDeTrabajo, Estado estado,
                               Observacion observacion) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.reparacionId = reparacionId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.estado = estado;
        this.observacion = observacion;
        this.inspeccionId = inspeccionId;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public RegistroId registroId() {
        return registroId;
    }

    public ReparacionId reparacionId() {
        return reparacionId;
    }

    public Estado estado() {
        return estado;
    }

    public Observacion observacion() {
        return observacion;
    }

    public InspeccionId inspeccionId() {
        return inspeccionId;
    }
}
