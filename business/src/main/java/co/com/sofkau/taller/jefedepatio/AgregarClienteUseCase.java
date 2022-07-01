package co.com.sofkau.taller.jefedepatio;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.taller.jefedepatio.commands.AgregarCliente;

/**
 * Caso de uso para el evento agregar Cliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();

        var jefeDePatio = JefeDePatio.from(command.jefeDePatioId(),
                repository().getEventsBy(command.jefeDePatioId().value()));

        jefeDePatio.agregarCliente(
                command.documento(),
                command.nombre(),
                command.telefono(),
                command.correo()
        );

        emit().onResponse(new ResponseEvents(jefeDePatio.getUncommittedChanges()));
    }
}
