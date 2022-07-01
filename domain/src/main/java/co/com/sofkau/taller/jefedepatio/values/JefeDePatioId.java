package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Jefe de patio
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class JefeDePatioId extends Identity {
    public JefeDePatioId(String id) {
        super(id);
    }

    public JefeDePatioId() {
    }

    public static JefeDePatioId of(String id) {
        return new JefeDePatioId(id);
    }
}
