package co.com.sofkau.taller.vendedor.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.vendedor.values.DatosAuto;
import co.com.sofkau.taller.vendedor.values.DatosCliente;
import co.com.sofkau.taller.vendedor.values.DatosEmpresa;
import co.com.sofkau.taller.vendedor.values.FacturaId;
import co.com.sofkau.taller.vendedor.values.ValorCompra;
import co.com.sofkau.taller.vendedor.values.ValorReparacion;
import co.com.sofkau.taller.vendedor.values.ValorTotal;
import co.com.sofkau.taller.vendedor.values.VendedorId;

import java.util.Set;

/**
 * Entidad Factura con sus comportamientos
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Factura extends Entity<FacturaId> {

    protected VendedorId vendedorId;
    protected DatosCliente datosCliente;
    protected Set<DatosEmpresa> datosEmpresa;
    protected Set<DatosAuto> datosAutos;
    protected Set<ListaRepuestos> listaRepuestos;
    protected ValorCompra valorCompra;
    protected ValorReparacion valorReparacion;
    protected ValorTotal valorTotal;

    public Factura(FacturaId entityId, VendedorId vendedorId,
                   DatosCliente datosCliente, Set<DatosEmpresa> datosEmpresa,
                   Set<DatosAuto> datosAutos, Set<ListaRepuestos> listaRepuestos,
                   ValorCompra valorCompra, ValorReparacion valorReparacion, ValorTotal valorTotal) {
        super(entityId);
        this.vendedorId = vendedorId;
        this.datosCliente = datosCliente;
        this.datosEmpresa = datosEmpresa;
        this.datosAutos = datosAutos;
        this.listaRepuestos = listaRepuestos;
        this.valorCompra = valorCompra;
        this.valorReparacion = valorReparacion;
        this.valorTotal = valorTotal;
    }


    public VendedorId vendedorId() {
        return vendedorId;
    }

    public void agregarDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public DatosCliente datosCliente() {
        return datosCliente;
    }

    public void agregarDatosEmpresa(Set<DatosEmpresa> datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public Set<DatosEmpresa> datosEmpresas() {
        return datosEmpresa;
    }

    public void agregarDatosAuto(Set<DatosAuto> datosAutos) {
        this.datosAutos = datosAutos;
    }

    public Set<DatosAuto> datosAutos() {
        return datosAutos;
    }

    public void agregarListaRepuestos(Set<ListaRepuestos> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public Set<ListaRepuestos> listaRepuestos() {
        return listaRepuestos;
    }

    public void agregarValorCompra(ValorCompra valorCompra) {
        this.valorCompra = valorCompra;
    }

    public ValorCompra valorCompra() {
        return valorCompra;
    }

    public void agregarValorReparacion(ValorReparacion valorReparacion) {
        this.valorReparacion = valorReparacion;
    }

    public ValorReparacion valorReparacion() {
        return valorReparacion;
    }

    public void agregarValorTotal(ValorTotal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ValorTotal valorTotal() {
        return valorTotal;
    }
}
