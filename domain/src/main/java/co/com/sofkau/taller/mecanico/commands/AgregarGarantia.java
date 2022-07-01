package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.mecanico.values.GarantiaId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;


public class AgregarGarantia extends Command {
    private final GarantiaId garantiaId;
    private final MecanicoId mecanicoId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;


    public AgregarGarantia(GarantiaId garantiaId, MecanicoId mecanicoId,
                           TipoDeTrabajo tipoDeTrabajo, Estado estado, Observacion observacion) {
        this.garantiaId = garantiaId;
        this.mecanicoId = mecanicoId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.estado = estado;
        this.observacion = observacion;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public GarantiaId garantiaId() {
        return garantiaId;
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
