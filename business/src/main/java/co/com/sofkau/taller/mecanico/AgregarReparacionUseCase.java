package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarReparacion;

/**
 * Caso de uso para el evento agregar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarReparacionUseCase extends UseCase<RequestCommand<AgregarReparacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReparacion> agregarReparacionRequestCommand) {
        var command = agregarReparacionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.mecanicoId(),
                repository().getEventsBy(command.mecanicoId().value()));

        mecanico.agregarTrabajo(command.tipoDeTrabajo(), command.estado(), command.observacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
