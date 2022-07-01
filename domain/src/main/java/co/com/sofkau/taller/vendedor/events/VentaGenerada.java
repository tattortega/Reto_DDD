package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.values.MetodoPago;
import co.com.sofkau.taller.vendedor.values.TipoDePago;
import co.com.sofkau.taller.vendedor.values.ValorReparacion;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class VentaGenerada extends DomainEvent {
    private final VendedorId vendedorId;
    private final TipoDePago tipoDePago;
    private final MetodoPago metodoPago;
    private final ValorReparacion valorReparacion;

    public VentaGenerada(VendedorId vendedorId, TipoDePago tipoDePago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        super("co.com.sofkau.taller.vendedor.VentaGenerada");
        this.vendedorId = vendedorId;
        this.tipoDePago = tipoDePago;
        this.metodoPago = metodoPago;
        this.valorReparacion = valorReparacion;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public TipoDePago tipoPago() {
        return tipoDePago;
    }

    public MetodoPago metodoPago() {
        return metodoPago;
    }

    public ValorReparacion valorReparacion() {
        return valorReparacion;
    }
}
