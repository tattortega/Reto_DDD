package co.com.sofkau.taller.vendedor.factory;



import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.vendedor.entities.Factura;
import co.com.sofkau.taller.vendedor.values.*;

import java.util.HashSet;
import java.util.Set;


public class FacturaFactory {
    private final Set<Factura> factura;

    public FacturaFactory() {
        factura = new HashSet<>();
    }

    public static FacturaFactory builder() {
        return new FacturaFactory();
    }

    public FacturaFactory agregarFactura(FacturaId facturaId, VendedorId vendedorId, DatosCliente datosCliente,
                                         Set<DatosEmpresa> datosEmpresa,
                                         Set<DatosAuto> datosAuto, Set<ListaRepuestos> listaRepuestos,
                                         ValorCompra valorCompra, ValorReparacion valorReparacion,
                                         ValorTotal valorTotal) {
        factura.add(new Factura(facturaId, vendedorId, datosCliente, datosEmpresa, datosAuto, listaRepuestos,
                valorCompra, valorReparacion, valorTotal));
        return this;
    }

    public Set<Factura> factura() {
        return factura;
    }
}
