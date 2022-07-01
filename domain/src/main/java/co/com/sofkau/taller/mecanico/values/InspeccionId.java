package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Inspeccion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class InspeccionId extends Identity {

    public InspeccionId(String id) {
        super(id);
    }

    public InspeccionId() {
    }

    public static InspeccionId of(String id) {
        return new InspeccionId(id);
    }
}
