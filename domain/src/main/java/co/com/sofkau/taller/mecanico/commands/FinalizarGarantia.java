package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.values.GarantiaId;
import co.com.sofkau.taller.mecanico.values.InspeccionId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Estado;
import co.com.sofkau.taller.valuesgeneric.Observacion;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;

/**
 * Comando para finalizar Garantia
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class FinalizarGarantia extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final GarantiaId garantiaId;
    private final InspeccionId inspeccionId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Estado estado;
    private final Observacion observacion;


    public FinalizarGarantia(VendedorId vendedorId, MecanicoId mecanicoId,
                             RegistroId registroId, GarantiaId garantiaId,
                             InspeccionId inspeccionId, TipoDeTrabajo tipoDeTrabajo, Estado estado, Observacion observacion) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.garantiaId = garantiaId;
        this.inspeccionId = inspeccionId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.estado = estado;
        this.observacion = observacion;
    }

    public InspeccionId inspeccionId() {
        return inspeccionId;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public RegistroId registroId() {
        return registroId;
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
