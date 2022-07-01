package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.CompraGenerada;


public class AgregarCompraUseCase extends UseCase<TriggeredEvent<CompraGenerada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CompraGenerada> compraGeneradaTriggeredEvent) {
        var event = compraGeneradaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.vendedorId(),
                repository().getEventsBy(event.vendedorId().value())
        );

        vendedor.crearCompra(event.vendedorId(), event.valorCompra());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
