package co.com.sofkau.taller.vendedor.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.values.CompraId;
import co.com.sofkau.taller.vendedor.values.ValorCompra;

/**
 * Entidad Compra con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Compra extends Entity<CompraId> {

    protected ValorCompra valorCompra;

    public Compra(CompraId entityId, ValorCompra valorCompra) {
        super(entityId);
        this.valorCompra = valorCompra;
    }

    public void agregarValorCompra(ValorCompra valorCompra) {
        this.valorCompra = valorCompra;
    }

    public ValorCompra valorCompra() {
        return valorCompra;
    }
}
