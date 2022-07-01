package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.Identity;

/**
 * Objeto de valor tipo Identity para Vendedor
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class VendedorId extends Identity {

    public VendedorId(String id) {
        super(id);
    }

    public VendedorId() {
    }

    public static VendedorId of(String id) {
        return new VendedorId(id);
    }
}
