package co.com.sofkau.taller.jefedepatio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.mecanico.values.MecanicoId;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class AsignarJefeDePatio extends Command {
    private final JefeDePatioId jefeDePatioId;
    private final MecanicoId mecanicoId;
    private final VendedorId vendedorId;
    private final Nombre nombre;
    private final Correo correo;
    private final Telefono telefono;

    public AsignarJefeDePatio(JefeDePatioId jefeDePatioId, MecanicoId mecanicoId, VendedorId vendedorId,
                              Nombre nombre, Correo correo, Telefono telefono) {
        this.jefeDePatioId = jefeDePatioId;
        this.mecanicoId = mecanicoId;
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public JefeDePatioId jefeDePatioId() {
        return jefeDePatioId;
    }

    public MecanicoId mecanicoId() {
        return mecanicoId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
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
}
