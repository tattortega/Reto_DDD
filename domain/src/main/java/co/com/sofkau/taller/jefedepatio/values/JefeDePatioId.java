package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

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
