package co.com.sofkau.taller.vendedor.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.values.*;

/**
 * Entidad Venta con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Venta extends Entity<VentaId> {
    protected TipoDePago tipoDePago;
    protected MetodoPago metodoPago;

    protected ValorReparacion valorReparacion;

    public Venta(VentaId entityId, TipoDePago tipoDePago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        super(entityId);
        this.tipoDePago = tipoDePago;
        this.metodoPago = metodoPago;
        this.valorReparacion = valorReparacion;
    }

    public void agregarTipoDePago(TipoDePago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public TipoDePago tipoDePago() {
        return tipoDePago;
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public MetodoPago metodoPago() {
        return metodoPago;
    }

    public void agregarValorReparacion(ValorReparacion valorReparacion) {
        this.valorReparacion = valorReparacion;
    }

    public ValorReparacion valorReparacion() {
        return valorReparacion;
    }
}
