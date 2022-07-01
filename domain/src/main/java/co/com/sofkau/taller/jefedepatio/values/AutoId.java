package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Auto
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AutoId extends Identity {
    public AutoId(String id) {
        super(id);
    }

    public AutoId() {
    }

    public static AutoId of(String id) {
        return new AutoId(id);
    }
}
