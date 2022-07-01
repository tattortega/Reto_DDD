package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.mecanico.entities.Garantia;
import co.com.sofkau.taller.mecanico.entities.Inspeccion;
import co.com.sofkau.taller.mecanico.entities.Reparacion;
import co.com.sofkau.taller.mecanico.events.GarantiaAgregada;
import co.com.sofkau.taller.mecanico.events.InspeccionAgregada;
import co.com.sofkau.taller.mecanico.events.MecanicoAsignado;
import co.com.sofkau.taller.mecanico.events.ReparacionAgregada;

import java.util.HashMap;

/**
 * Controlados de eventos del agregado Mecanico
 */
public class MecanicoEventChange extends EventChange {
    public MecanicoEventChange(Mecanico mecanico) {
        apply((MecanicoAsignado event) -> {
            mecanico.nombre = event.nombre();
            mecanico.telefono = event.telefono();
            mecanico.correo = event.correo();
            mecanico.tipoDeTrabajo = event.tipoDeTrabajo();
            mecanico.garantia = new HashMap<>();
            mecanico.inspeccion = new HashMap<>();
            mecanico.reparacion = new HashMap<>();
            mecanico.vendedorId = event.vendedorId();
        });
        apply((InspeccionAgregada event) -> {
            var inspeccionId = event.inspeccionId();
            var inspeccion = new Inspeccion(inspeccionId, event.diagnostico(), event.listaRepuestos());
            mecanico.inspeccion.put(inspeccionId, inspeccion);
        });
        apply((ReparacionAgregada event) -> {
            var repacionId = event.reparacionId();
            var reparacion = new Reparacion(repacionId, event.estado(), event.observacion());
            mecanico.reparacion.put(repacionId, reparacion);
        });
        apply((GarantiaAgregada event) -> {
            var garantiaId = event.garantiaId();
            var garantia = new Garantia(garantiaId, event.estado(), event.observacion());
            mecanico.garantia.put(garantiaId, garantia);
        });
    }
}
