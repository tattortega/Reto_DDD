package co.com.sofkau.taller.jefedepatio;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.jefedepatio.JefeDePatio;
import co.com.sofkau.taller.jefedepatio.commands.AgregarAuto;


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
