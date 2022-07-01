package co.com.sofkau.taller.vendedor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.entities.Compra;
import co.com.sofkau.taller.vendedor.entities.Entrega;
import co.com.sofkau.taller.vendedor.entities.Factura;
import co.com.sofkau.taller.vendedor.entities.Venta;
import co.com.sofkau.taller.vendedor.events.CompraGenerada;
import co.com.sofkau.taller.vendedor.events.EntregaRealizada;
import co.com.sofkau.taller.vendedor.events.FacturaGenerada;
import co.com.sofkau.taller.vendedor.events.VendedorAsignado;
import co.com.sofkau.taller.vendedor.events.VentaGenerada;
import co.com.sofkau.taller.vendedor.values.CompraId;
import co.com.sofkau.taller.vendedor.values.DatosAuto;
import co.com.sofkau.taller.vendedor.values.DatosCliente;
import co.com.sofkau.taller.vendedor.values.DatosEmpresa;
import co.com.sofkau.taller.vendedor.values.EntregaId;
import co.com.sofkau.taller.vendedor.values.FacturaId;
import co.com.sofkau.taller.vendedor.values.MetodoPago;
import co.com.sofkau.taller.vendedor.values.Salida;
import co.com.sofkau.taller.vendedor.values.TipoDePago;
import co.com.sofkau.taller.vendedor.values.ValorCompra;
import co.com.sofkau.taller.vendedor.values.ValorReparacion;
import co.com.sofkau.taller.vendedor.values.ValorTotal;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import co.com.sofkau.taller.vendedor.values.VentaId;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Agregado root para Vendedor con sus atributos y comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Vendedor extends AggregateEvent<VendedorId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Correo correo;
    protected Map<CompraId, Compra> compra;
    protected Map<VentaId, Venta> venta;
    protected Map<EntregaId, Entrega> entrega;
    protected Map<FacturaId, Factura> factura;
    protected Set<Cliente> cliente;
    protected Set<Auto> auto;
    protected Set<ListaRepuestos> listaRepuestos;

    public Vendedor(VendedorId entityId, Nombre nombre, Telefono telefono, Correo correo,
                    Set<Cliente> cliente, Set<Auto> auto, Set<ListaRepuestos> listaRepuestos) {
        super(entityId);
        appendChange(new VendedorAsignado(entityId, nombre, telefono, correo, cliente, auto, listaRepuestos));
        subscribe(new VendedorEventChange(this));
    }

    private Vendedor(VendedorId entityId) {
        super(entityId);
        subscribe(new VendedorEventChange(this));
    }

    public static Vendedor from(VendedorId entityId, List<DomainEvent> events) {
        var vendedor = new Vendedor(entityId);
        events.forEach(vendedor::applyEvent);
        return vendedor;
    }

    public void crearCompra(VendedorId vendedorId, ValorCompra compra) {
        appendChange(new CompraGenerada(vendedorId, compra)).apply();
    }


    public void crearVenta(VendedorId vendedorId, TipoDePago tipoDePago, MetodoPago metodoPago, ValorReparacion valorReparacion) {
        appendChange(new VentaGenerada(vendedorId, tipoDePago, metodoPago, valorReparacion)).apply();
    }

    public void crearEntrega(VendedorId vendedorId, Salida salida, ValorTotal valorTotal) {
        appendChange(new EntregaRealizada(vendedorId, salida, valorTotal)).apply();
    }

    public void crearFactura(FacturaId facturaId, VendedorId vendedorId, DatosCliente datosCliente,
                             Set<DatosEmpresa> datosEmpresa, Set<DatosAuto> datosAuto,
                             Set<ListaRepuestos> listaRepuestos, ValorCompra valorCompra,
                             ValorReparacion valorReparacion, ValorTotal valorTotal) {
        appendChange(new FacturaGenerada(facturaId, vendedorId, datosCliente, datosEmpresa, datosAuto,
                listaRepuestos, valorCompra, valorReparacion, valorTotal)).apply();


    }
}
