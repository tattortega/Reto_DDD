package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.Identity;

public class CompraId extends Identity {
    public CompraId(String id) {
        super(id);
    }

    public CompraId() {
    }

    public static CompraId of(String id) {
        return new CompraId(id);
    }
}
