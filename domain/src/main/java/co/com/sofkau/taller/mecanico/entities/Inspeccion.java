package co.com.sofkau.taller.mecanico.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.mecanico.values.Diagnostico;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;

import java.util.Set;


public class Inspeccion extends Entity<InspeccionId> {
    protected Diagnostico diagnostico;
    protected Set<ListaRepuestos> listaRepuestos;

    public Inspeccion(InspeccionId inspeccionId, Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestos) {
        super(inspeccionId);
        this.diagnostico = diagnostico;
        this.listaRepuestos = listaRepuestos;
    }

    public Diagnostico diagnostico() {
        return diagnostico;
    }

    public void agregarDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }

    public void agregarListaRepuestos(Set<ListaRepuestos> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }
}
