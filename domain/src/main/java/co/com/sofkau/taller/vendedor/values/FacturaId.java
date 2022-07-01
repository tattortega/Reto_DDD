package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Factura
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class FacturaId extends Identity {
    public FacturaId(String id) {
        super(id);
    }

    public FacturaId() {
    }

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
