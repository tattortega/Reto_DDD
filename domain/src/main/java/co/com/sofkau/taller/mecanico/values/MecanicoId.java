package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Mecanico
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
