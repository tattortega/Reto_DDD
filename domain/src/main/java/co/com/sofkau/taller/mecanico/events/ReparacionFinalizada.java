package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.entities.Inspeccion;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.ReparacionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.Map;

/**
 * Evento de dominio para finalizar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ReparacionFinalizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final ReparacionId reparacionId;
    private final Estado estado;
    private final Observacion observacion;
    private final transient Map<InspeccionId, Inspeccion> inspeccion;


    public ReparacionFinalizada(VendedorId vendedorId, RegistroId registroId, ReparacionId reparacionId, Estado estado, Observacion observacion, Map<InspeccionId, Inspeccion> inspeccion) {
        super("co.com.sofkau.taller.mecanico.ReparacionFinalizada");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.reparacionId = reparacionId;
        this.estado = estado;
        this.observacion = observacion;
        this.inspeccion = inspeccion;
    }

    public Map<InspeccionId, Inspeccion> inspeccion() {
        return inspeccion;
    }

    public RegistroId registroId() {
        return registroId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
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
