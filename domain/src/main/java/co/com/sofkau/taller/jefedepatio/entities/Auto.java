package co.com.sofkau.taller.jefedepatio.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.jefedepatio.values.AutoId;
import co.com.sofkau.taller.jefedepatio.values.Marca;
import co.com.sofkau.taller.jefedepatio.values.Placa;

/**
 * Entidad Auto con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Auto extends Entity<AutoId> {

    protected Marca marca;
    protected Placa placa;

    public Auto(AutoId entityId, Marca marca, Placa placa) {
        super(entityId);
        this.marca = marca;
        this.placa = placa;
    }

    public Marca marca() {
        return marca;
    }

    public void agregarMarca(Marca marca) {
        this.marca = marca;
    }

    public Placa placa() {
        return placa;
    }

    public void agregarPlaca(Placa placa) {
        this.placa = placa;
    }
}
