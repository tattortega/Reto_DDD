package co.com.sofkau.taller.mecanico;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.FinalizarReparacion;

/**
 * Caso de uso para el evento finalizar Reparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class FinalizarReparacionUseCase extends UseCase<RequestCommand<FinalizarReparacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<FinalizarReparacion> finalizarReparacionRequestCommand) {
        var command = finalizarReparacionRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.mecanicoId(),
                repository().getEventsBy(command.mecanicoId().value()));

        mecanico.finalizarTrabajo(command.tipoDeTrabajo(), command.observacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
