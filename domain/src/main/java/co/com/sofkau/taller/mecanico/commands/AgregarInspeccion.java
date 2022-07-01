package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.mecanico.values.Diagnostico;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.mecanico.values.MecanicoId;

import java.util.Set;


public class AgregarInspeccion extends Command {
    private final InspeccionId inspeccionId;
    private final MecanicoId mecanicoId;
    private final Diagnostico diagnostico;
    private final Set<ListaRepuestos> listaRepuestos;

    public AgregarInspeccion(InspeccionId inspeccionId, MecanicoId mecanicoId,
                             Diagnostico diagnostico, Set<ListaRepuestos> listaRepuestos) {
        this.inspeccionId = inspeccionId;
        this.mecanicoId = mecanicoId;
        this.diagnostico = diagnostico;
        this.listaRepuestos = listaRepuestos;
    }

    public InspeccionId inspeccionId() {
        return inspeccionId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public Diagnostico diagnostico() {
        return diagnostico;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }
}
