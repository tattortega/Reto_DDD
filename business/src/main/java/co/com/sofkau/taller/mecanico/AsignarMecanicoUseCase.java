package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AsignarMecanico;

/**
 * Caso de uso para que un mecanico sea asignado a un cliente
 */
public class AsignarMecanicoUseCase extends UseCase<RequestCommand<AsignarMecanico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarMecanico> asignarMecanicoRequestCommand) {
        var command = asignarMecanicoRequestCommand.getCommand();

        var mecanico = new Mecanico(command.mecanicoId(), command.vendedorId(), command.registroId(),
                command.nombre(), command.correo(), command.telefono(), command.tipoDeTrabajo());

        emit().onResponse(new ResponseEvents(mecanico.getUncommittedChanges()));
    }
}
