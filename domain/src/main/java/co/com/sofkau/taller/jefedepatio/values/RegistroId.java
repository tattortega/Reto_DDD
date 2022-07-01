package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Registro
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class RegistroId extends Identity {
    public RegistroId(String id) {
        super(id);
    }

    public RegistroId() {
    }

    public static RegistroId of(String id) {
        return new RegistroId(id);
    }
}
