package co.com.sofkau.taller.mecanico;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.mecanico.commands.AsignarMecanico;

/**
 * Caso de uso para el evento asignar Mecanico
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
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
