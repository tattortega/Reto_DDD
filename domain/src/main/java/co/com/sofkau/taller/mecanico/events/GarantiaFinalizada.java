package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.entities.Inspeccion;
import co.com.sofkau.taller.mecanico.values.GarantiaId;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.Map;

/**
 * Evento de dominio para finalizar Garantia
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class GarantiaFinalizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final RegistroId registroId;
    private final GarantiaId garantiaId;
    private final Estado estado;
    private final Observacion observacion;
    private final transient Map<InspeccionId, Inspeccion> inspeccion;

    public GarantiaFinalizada(VendedorId vendedorId, RegistroId registroId, GarantiaId garantiaId, Estado estado, Observacion observacion, Map<InspeccionId, Inspeccion> inspeccion) {
        super("co.com.sofkau.taller.mecanico.GarantiaFinalizada");
        this.vendedorId = vendedorId;
        this.registroId = registroId;
        this.garantiaId = garantiaId;
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

    public GarantiaId garantiaId() {
        return garantiaId;
    }

    public Estado estados() {
        return estado;
    }

    public Observacion observacion() {
        return observacion;
    }
}
