package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ReparacionId extends Identity {
    public ReparacionId(String id) {
        super(id);
    }

    public ReparacionId() {
    }

    public static ReparacionId of(String id) {
        return new ReparacionId(id);
    }
}
