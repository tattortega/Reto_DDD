package co.com.sofkau.taller.mecanico.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.values.Diagnostico;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;

import java.util.Set;

/**
 * Evento de dominio para agregar Inspeccion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class InspeccionAgregada extends DomainEvent {
    private final InspeccionId inspeccionId;
    private final Diagnostico diagnostico;
    private final Set<ListaRepuestos> listaRepuestos;

    public InspeccionAgregada(InspeccionId inspeccionId, Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestos) {
        super("co.com.sofkau.taller.mecanico.InspeccionAgregada");
        this.inspeccionId = inspeccionId;
        this.diagnostico = diagnostico;
        this.listaRepuestos = listaRepuestos;
    }

    public InspeccionId inspeccionId() {
        return inspeccionId;
    }

    public Diagnostico diagnostico() {
        return diagnostico;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }
}
