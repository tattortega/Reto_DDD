package co.com.sofkau.taller.jefedepatio.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.Marca;
import co.com.sofkau.taller.jefedepatio.values.Placa;

/**
 * Evento de dominio para agregar Auto
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AutoAgregado extends DomainEvent {
    private final AutoId autoId;
    private final Marca marca;
    private final Placa placa;

    public AutoAgregado(AutoId autoId, Marca marca, Placa placa) {
        super("co.com.sofkau.taller.jefedepatio.AutoAgregado");
        this.autoId = autoId;
        this.marca = marca;
        this.placa = placa;
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
