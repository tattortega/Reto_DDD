package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.taller.vendedor.entities.Compra;
import co.com.sofkau.taller.vendedor.entities.Factura;
import co.com.sofkau.taller.vendedor.entities.Venta;
import co.com.sofkau.taller.vendedor.events.*;
import co.com.sofkau.taller.vendedor.values.CompraId;
import co.com.sofkau.taller.vendedor.values.FacturaId;
import co.com.sofkau.taller.vendedor.values.VentaId;

import java.util.HashMap;

/**
 * Manejador de Eventos para Vendedor
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class VendedorEventChange extends EventChange {
    public VendedorEventChange(Vendedor vendedor) {
        apply((VendedorAsignado event) -> {
            vendedor.nombre = event.nombre();
            vendedor.telefono = event.telefono();
            vendedor.correo = event.correo();
            vendedor.listaRepuestos = event.listaRepuestos();
            vendedor.cliente = event.clientes();
            vendedor.auto = event.autos();
            vendedor.venta = new HashMap<>();
            vendedor.compra = new HashMap<>();
            vendedor.factura = new HashMap<>();
        });

        apply((VentaGenerada event) -> {
            var ventaId = new VentaId();
            var venta = new Venta(ventaId, event.tipoPago(), event.metodoPago(), event.valorReparacion());
            vendedor.venta.put(ventaId, venta);
        });

        apply((CompraGenerada event) -> {
            var compraId = new CompraId();
            var compra = new Compra(compraId, event.valorCompra());
            vendedor.compra.put(compraId, compra);
        });

        apply((FacturaGenerada event) -> {
            var facturaId = new FacturaId();
            var factura = new Factura(facturaId, event.vendedorId(), event.datosCliente(),
                    event.datosEmpresas(), event.datosAutos(), event.listaRepuestos(), event.valorCompra(),
                    event.valorReparacion(), event.valorTotal());
            vendedor.factura.put(facturaId, factura);
        });
    }
}
