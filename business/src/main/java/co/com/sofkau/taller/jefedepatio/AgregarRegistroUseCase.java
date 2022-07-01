package co.com.sofkau.taller.jefedepatio;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.jefedepatio.JefeDePatio;
import co.com.sofkau.taller.jefedepatio.commands.AgregarRegistro;


public class AgregarRegistroUseCase extends UseCase<RequestCommand<AgregarRegistro>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarRegistro> agregarRegistroRequestCommand) {
        var command = agregarRegistroRequestCommand.getCommand();

        var jefeDePatio = JefeDePatio.from(command.jefeDePatioId(),
                repository().getEventsBy(command.jefeDePatioId().value()));

        jefeDePatio.agregarRegistro(command.tipoDeTrabajo(), command.ingreso(),
                command.autorizacionCliente());

        emit().onResponse(new ResponseEvents(jefeDePatio.getUncommittedChanges()));
    }
}
