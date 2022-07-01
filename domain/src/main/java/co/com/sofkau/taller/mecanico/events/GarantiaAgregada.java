package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.values.GarantiaId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;

/**
 * Evento de dominio para agregar Garantia
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class GarantiaAgregada extends DomainEvent {
    private final GarantiaId garantiaId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;

    public GarantiaAgregada(GarantiaId garantiaId, TipoDeTrabajo tipoDeTrabajo, Estado estado, Observacion observacion) {
        super("co.com.sofkau.taller.mecanico.GarantiaAgregada");
        this.garantiaId = garantiaId;
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

    public Estado estado() {
        return estado;
    }

    public Observacion observacion() {
        return observacion;
    }
}
