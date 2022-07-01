package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;


public class ReparacionAgregada extends DomainEvent {
    private final ReparacionId reparacionId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;

    public ReparacionAgregada(ReparacionId reparacionId, TipoDeTrabajo tipoDeTrabajo,
                              Estado estado, Observacion observacion) {
        super("co.com.sofkau.taller.mecanico.ReparacionAgregada");
        this.reparacionId = reparacionId;
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

    public Estado estado() {
        return estado;
    }

    public Observacion observacion() {
        return observacion;
    }
}
