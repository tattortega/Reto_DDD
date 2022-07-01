package co.com.sofkau.taller.mecanico.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;

/**
 * Entidad Reparacion con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Reparacion extends Entity<ReparacionId> {

    protected Estado estado;
    protected Observacion observacion;

    public Reparacion(ReparacionId reparacionId, Estado estado, Observacion observacion) {
        super(reparacionId);
        this.estado = estado;
        this.observacion = observacion;
    }

    public Estado estado() {
        return estado;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }

    public Observacion observacion() {
        return observacion;
    }

    public void agregarObservacion(Observacion observacion) {
        this.observacion = observacion;
    }
}
