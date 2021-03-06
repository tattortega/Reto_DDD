package co.com.sofkau.taller.jefedepatio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.jefedepatio.values.Marca;
import co.com.sofkau.taller.jefedepatio.values.Placa;

/**
 * Comando para agregar Auto
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarAuto extends Command {
    private final AutoId autoId;
    private final JefeDePatioId jefeDePatioId;
    private final Marca marca;
    private final Placa placa;


    public AgregarAuto(AutoId autoId, JefeDePatioId jefeDePatioId, Marca marca, Placa placa) {
        this.autoId = autoId;
        this.jefeDePatioId = jefeDePatioId;
        this.marca = marca;
        this.placa = placa;
    }

    public JefeDePatioId jefeDePatioId() {
        return jefeDePatioId;
    }

    public AutoId autoId() {
        return autoId;
    }

    public Marca marca() {
        return marca;
    }

    public Placa placa() {
        return placa;
    }
}
