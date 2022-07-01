package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.EntregaRealizada;


public class AgregarEntregaUseCase extends UseCase<TriggeredEvent<EntregaRealizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EntregaRealizada> entregaRealizadaTriggeredEvent) {
        var event = entregaRealizadaTriggeredEvent.getDomainEvent();

        var vendedor = Vendedor.from(
                event.vendedorId(),
                repository().getEventsBy(event.vendedorId().value())
        );

        vendedor.crearEntrega(event.vendedorId(), event.salida(), event.valorTotal());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}