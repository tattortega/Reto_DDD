package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.Identity;

public class MecanicoId extends Identity {
    public MecanicoId(String id) {
        super(id);
    }

    public MecanicoId() {
    }

    public static MecanicoId of(String id) {
        return new MecanicoId(id);
    }
}
