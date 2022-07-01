package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarInspeccion;

/**
 * Caso de uso para el evento agregar Inspeccion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarInspeccionUseCase extends UseCase<RequestCommand<AgregarInspeccion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarInspeccion> agregarInspeccionRequestCommand) {
        var command = agregarInspeccionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.mecanicoId(),
                repository().getEventsBy(command.mecanicoId().value()));

        mecanico.agregarInspeccion(command.diagnostico(), command.listaRepuestos());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
