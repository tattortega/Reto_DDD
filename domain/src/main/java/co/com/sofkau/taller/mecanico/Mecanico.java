package co.com.sofkau.taller.mecanico;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.entities.Garantia;
import co.com.sofkau.taller.mecanico.entities.Inspeccion;
import co.com.sofkau.taller.mecanico.entities.Reparacion;
import co.com.sofkau.taller.mecanico.events.*;
import co.com.sofkau.taller.mecanico.values.*;
import co.com.sofkau.taller.valuesgeneric.*;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Agregado root para Mecanico con sus atributos y comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Mecanico extends AggregateEvent<MecanicoId> {

    protected VendedorId vendedorId;

    protected RegistroId registroId;

    protected Nombre nombre;

    protected Correo correo;

    protected Telefono telefono;

    protected TipoDeTrabajo tipoDeTrabajo;
    protected Map<InspeccionId, Inspeccion> inspeccion;
    protected Map<ReparacionId, Reparacion> reparacion;
    protected Map<GarantiaId, Garantia> garantia;

    private Mecanico(MecanicoId mecanicoId) {
        super(mecanicoId);
        subscribe(new MecanicoEventChange(this));
    }

    public Mecanico(MecanicoId mecanicoId, VendedorId vendedorId, RegistroId registroId, Nombre nombre,
                    Correo correo, Telefono telefono, TipoDeTrabajo tipoDeTrabajo) {
        super(mecanicoId);
        appendChange(new MecanicoAsignado(vendedorId, registroId, nombre, telefono, correo, tipoDeTrabajo)).apply();
        subscribe(new MecanicoEventChange(this));
    }


    public static Mecanico from(MecanicoId mecanicoId, List<DomainEvent> events) {
        var mecanico = new Mecanico(mecanicoId);
        events.forEach(mecanico::applyEvent);
        return mecanico;
    }

    public void agregarInspeccion(Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestos) {
        var inspeccionId = new InspeccionId();
        appendChange(new InspeccionAgregada(inspeccionId, diagnostico, listaRepuestos));
    }

    public void agregarTrabajo(TipoDeTrabajo tipoDeTrabajo, Estado estado, Observacion observacion) {
        if (tipoDeTrabajo.value().equals(TipoDeTrabajo.Tipos.REPARACION) && estado.value().equals(Estado.Estados.EMPEZADO)) {
            var reparacionId = new ReparacionId();
            appendChange(new ReparacionAgregada(reparacionId, tipoDeTrabajo, estado, observacion));
        } else if (tipoDeTrabajo.value().equals(TipoDeTrabajo.Tipos.GARANTIA) && estado.value().equals(Estado.Estados.EMPEZADO)) {
            var garantiaId = new GarantiaId();
            appendChange(new GarantiaAgregada(garantiaId, tipoDeTrabajo, estado, observacion));
        } else {
            throw new IllegalArgumentException("El trabajo ya fue finalizado");
        }

    }

    public void finalizarTrabajo(TipoDeTrabajo tipoDeTrabajo, Observacion observacion) {
        if (tipoDeTrabajo.value().equals(TipoDeTrabajo.Tipos.REPARACION)) {
            var idReparacion = reparacion.keySet().
                    stream().
                    iterator().
                    next();
            var estadoFinalizado = reparacion.get(idReparacion)
                    .estado()
                    .finalizar();
            appendChange(new ReparacionFinalizada(vendedorId, registroId, idReparacion, estadoFinalizado, observacion, inspeccion));
        }
        if (tipoDeTrabajo.value().equals(TipoDeTrabajo.Tipos.GARANTIA)) {
            var idGarantia = garantia.keySet().
                    stream().
                    iterator().
                    next();
            var estadoFinalizado = garantia.get(idGarantia)
                    .estado()
                    .finalizar();
            appendChange(new GarantiaFinalizada(vendedorId, registroId, idGarantia, estadoFinalizado, observacion, inspeccion));
        }
    }

    public RegistroId registroId() {
        return registroId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Correo correo() {
        return correo;
    }

    public Telefono telefono() {
        return telefono;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public Map<InspeccionId, Inspeccion> inspeccion() {
        return inspeccion;
    }

    public Map<ReparacionId, Reparacion> reparacion() {
        return reparacion;
    }

    public Map<GarantiaId, Garantia> garantia() {
        return garantia;
    }
}
