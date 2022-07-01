package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.Identity;

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
