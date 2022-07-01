package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.FacturaGenerada;
import co.com.sofkau.taller.vendedor.factory.FacturaFactory;


public class AgregarFacturaUseCase extends UseCase<TriggeredEvent<FacturaGenerada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FacturaGenerada> facturaGeneradaTriggeredEvent) {
        var event = facturaGeneradaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.vendedorId(),
                repository().getEventsBy(event.vendedorId().value())
        );

        FacturaFactory factory = FacturaFactory.builder()
                .agregarFactura(
                        event.facturaId(), event.vendedorId(), event.datosCliente(), event.datosEmpresas(),
                        event.datosAutos(), event.listaRepuestos(), event.valorCompra(),
                        event.valorReparacion(), event.valorTotal()
                );

        vendedor.crearFactura(event.facturaId(),
                event.vendedorId(), factory.factura().stream().iterator().next().datosCliente(),
                factory.factura().stream().iterator().next().datosEmpresas(),
                factory.factura().stream().iterator().next().datosAutos(),
                factory.factura().stream().iterator().next().listaRepuestos(),
                factory.factura().stream().iterator().next().valorCompra(),
                factory.factura().stream().iterator().next().valorReparacion(),
                factory.factura().stream().iterator().next().valorTotal()
        );

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
