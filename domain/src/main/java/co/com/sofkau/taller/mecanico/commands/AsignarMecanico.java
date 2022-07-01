package co.com.sofkau.taller.mecanico.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class AsignarMecanico extends Command {
    private final VendedorId vendedorId;
    private final MecanicoId mecanicoId;
    private final RegistroId registroId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Correo correo;
    private final TipoDeTrabajo tipoDeTrabajo;

    public AsignarMecanico(VendedorId vendedorId, MecanicoId mecanicoId, RegistroId registroId,
                           Nombre nombre, Telefono telefono, Correo correo, TipoDeTrabajo tipoDeTrabajo) {
        this.vendedorId = vendedorId;
        this.mecanicoId = mecanicoId;
        this.registroId = registroId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoDeTrabajo = tipoDeTrabajo;
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

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Correo correo() {
        return correo;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }
}
