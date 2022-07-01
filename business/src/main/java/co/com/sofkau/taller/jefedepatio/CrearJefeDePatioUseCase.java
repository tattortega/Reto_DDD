package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.jefedepatio.commands.AsignarJefeDePatio;

/**
 * Caso de uso para el evento crear Jefe de patio
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class CrearJefeDePatioUseCase extends UseCase<RequestCommand<AsignarJefeDePatio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarJefeDePatio> asignarAsesorRequestCommand) {
        var command = asignarAsesorRequestCommand.getCommand();

        var jefeDePatio = new JefeDePatio(
                command.jefeDePatioId(),
                command.mecanicoId(),
                command.vendedorId(),
                command.nombre(),
                command.correo(),
                command.telefono()
        );
        emit().onResponse(new ResponseEvents(jefeDePatio.getUncommittedChanges()));
    }
}
