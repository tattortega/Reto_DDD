package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.jefedepatio.commands.AgregarAuto;

/**
 * Caso de uso para el evento agregar Auto
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarAutoUseCase extends UseCase<RequestCommand<AgregarAuto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarAuto> agregarAutoRequestCommand) {
        var command = agregarAutoRequestCommand.getCommand();

        var jefeDePatio = JefeDePatio.from(command.jefeDePatioId(),
                repository().getEventsBy(command.jefeDePatioId().value()));

        jefeDePatio.agregarAuto(command.marca(), command.placa());

        emit().onResponse(new ResponseEvents(jefeDePatio.getUncommittedChanges()));
    }
}
