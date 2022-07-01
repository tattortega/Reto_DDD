package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Garantia
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class GarantiaId extends Identity {
    public GarantiaId(String id) {
        super(id);
    }

    public GarantiaId() {
    }

    public static GarantiaId of(String id) {
        return new GarantiaId(id);
    }
}
