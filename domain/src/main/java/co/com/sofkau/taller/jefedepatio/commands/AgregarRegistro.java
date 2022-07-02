package co.com.sofkau.taller.jefedepatio.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.ClienteId;
import co.com.sofkau.taller.jefedepatio.values.Ingreso;
import co.com.sofkau.taller.jefedepatio.values.JefeDePatioId;
import co.com.sofkau.taller.jefedepatio.values.RegistroId;
import co.com.sofkau.taller.valuesgeneric.TipoDeTrabajo;

/**
 * Comando para agregar Registro
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarRegistro extends Command {
    private final RegistroId registroId;
    private final JefeDePatioId jefeDePatioId;
    private final ClienteId clienteId;
    private final AutoId autoId;
    private final TipoDeTrabajo tipoDeTrabajo;
    private final Ingreso ingreso;

    public AgregarRegistro(RegistroId registroId, JefeDePatioId jefeDePatioId, ClienteId clienteId, AutoId autoId,
                           TipoDeTrabajo tipoDeTrabajo, Ingreso ingreso) {
        this.registroId = registroId;
        this.jefeDePatioId = jefeDePatioId;
        this.clienteId = clienteId;
        this.autoId = autoId;
        this.tipoDeTrabajo = tipoDeTrabajo;
        this.ingreso = ingreso;
    }

    public JefeDePatioId jefeDePatioId() {
        return jefeDePatioId;
    }

    public TipoDeTrabajo tipoDeTrabajo() {
        return tipoDeTrabajo;
    }

    public RegistroId registroId() {
        return registroId;
    }

    public Ingreso ingreso() {
        return ingreso;
    }


    public ClienteId clienteId() {
        return clienteId;
    }

    public AutoId autoId() {
        return autoId;
    }
}
