package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Cliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ClienteId extends Identity {
    public ClienteId(String id) {
        super(id);
    }

    public ClienteId() {
    }

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }
}
