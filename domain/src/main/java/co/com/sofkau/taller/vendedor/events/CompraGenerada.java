package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.values.ValorCompra;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class CompraGenerada extends DomainEvent {
    private final VendedorId vendedorId;
    private final ValorCompra valorCompra;

    public CompraGenerada(VendedorId vendedorId, ValorCompra valorCompra) {
        super("co.com.sofkau.taller.vendedor.CompraGenerada");
        this.vendedorId = vendedorId;
        this.valorCompra = valorCompra;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public ValorCompra valorCompra() {
        return valorCompra;
    }
}
