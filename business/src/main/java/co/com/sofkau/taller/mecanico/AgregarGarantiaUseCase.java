package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AgregarGarantia;


public class AgregarGarantiaUseCase extends UseCase<RequestCommand<AgregarGarantia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarGarantia> agregarGarantiaRequestCommand) {
        var command = agregarGarantiaRequestCommand.getCommand();

        var mecanico = Mecanico.from(command.mecanicoId(),
                repository().getEventsBy(command.mecanicoId().value()));

        mecanico.agregarTrabajo(command.tipoDeTrabajo(), command.estado(), command.observacion());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
