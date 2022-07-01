package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.vendedor.events.VendedorAsignado;


public class AsignarVendedorUseCase extends UseCase<TriggeredEvent<VendedorAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VendedorAsignado> vendedorAsignadoTriggeredEvent) {
        var event = vendedorAsignadoTriggeredEvent.getDomainEvent();

        var vendedor = new Vendedor(event.vendedorId(), event.nombre(),
                event.telefono(), event.correo(), event.clientes(),
                event.autos(), event.listaRepuestos());

        emit().onResponse(new ResponseEvents(vendedor.getUncommittedChanges()));
    }
}
