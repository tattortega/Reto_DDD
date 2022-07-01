package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Venta
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class VentaId extends Identity {
    public VentaId(String id) {
        super(id);
    }

    public VentaId() {
    }

    public static VentaId of(String id) {
        return new VentaId(id);
    }
}
