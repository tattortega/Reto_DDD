package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;

/**
 * Comando para agregar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarReparacion extends Command {
    private final ReparacionId reparacionId;
    private final MecanicoId mecanicoId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;


    public AgregarReparacion(ReparacionId reparacionId, MecanicoId mecanicoId,
                             TipoDeTrabajo tipoDeTrabajo, Estado estado, Observacion observacion) {
        this.reparacionId = reparacionId;
        this.mecanicoId = mecanicoId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.estado = estado;
        this.observacion = observacion;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public ReparacionId reparacionId() {
        return reparacionId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public Estado estado() {
        return estado;
    }

    public Observacion observacion() {
        return observacion;
    }
}
