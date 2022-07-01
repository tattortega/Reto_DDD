package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.vendedor.values.*;

import java.util.Set;


public class FacturaGenerada extends DomainEvent {
    private final FacturaId facturaId;
    private final VendedorId vendedorId;
    private final DatosCliente datosCliente;
    private final Set<DatosEmpresa> datosEmpresa;
    private final Set<DatosAuto> datosAutos;
    private final Set<ListaRepuestos> listaRepuestos;
    private final ValorCompra valorCompra;
    private final ValorReparacion valorReparacion;
    private final ValorTotal valorTotal;

    public FacturaGenerada(FacturaId facturaId, VendedorId vendedorId, DatosCliente datosCliente, Set<DatosEmpresa> datosEmpresa, Set<DatosAuto> datosAutos, Set<ListaRepuestos> listaRepuestos,
                           ValorCompra valorCompra, ValorReparacion valorReparacion, ValorTotal valorTotal) {
        super("co.com.sofkau.taller.vendedor.EntregaRealizada");
        this.facturaId = facturaId;
        this.vendedorId = vendedorId;
        this.datosCliente = datosCliente;
        this.datosEmpresa = datosEmpresa;
        this.datosAutos = datosAutos;
        this.listaRepuestos = listaRepuestos;
        this.valorCompra = valorCompra;
        this.valorReparacion = valorReparacion;
        this.valorTotal = valorTotal;
    }

    public FacturaId facturaId() {
        return facturaId;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public DatosCliente datosCliente() {
        return datosCliente;
    }

    public Set<DatosEmpresa> datosEmpresas() {
        return datosEmpresa;
    }

    public Set<DatosAuto> datosAutos() {
        return datosAutos;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }

    public ValorCompra valorCompra() {
        return valorCompra;
    }

    public ValorReparacion valorReparacion() {
        return valorReparacion;
    }

    public ValorTotal valorTotal() {
        return valorTotal;
    }
}
