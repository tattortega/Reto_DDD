package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.VentaGenerada;

/**
 * Caso de uso para el evento generar Factura
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class GenerarVentaUseCase extends UseCase<TriggeredEvent<VentaGenerada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VentaGenerada> ventaGeneradaTriggeredEvent) {
        var event = ventaGeneradaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.vendedorId(),
                repository().getEventsBy(event.vendedorId().value())
        );

        vendedor.crearVenta(event.vendedorId(), event.tipoPago(), event.metodoPago(),
                event.valorReparacion());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
