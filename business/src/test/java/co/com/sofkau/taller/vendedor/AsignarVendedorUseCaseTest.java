package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.jefedepatio.values.*;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.events.VendedorAsignado;
import co.com.sofkau.taller.vendedor.values.VendedorId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class AsignarVendedorUseCaseTest {

    @Test
    void asignarVendedor() {
        var vendedorId = VendedorId.of("03");
        var nombreVendedor = new Nombre("Natalia");
        var telefonoVendedor = new Telefono("3135687485");
        var correoVendedor = new Correo("natalia@chevrocentro.com");
        Set<Cliente> clientes = new HashSet<>();
        var clienteId = ClienteId.of("142");
        var documentoCliente = new Documento("109563625");
        var nombreCliente = new Nombre("Raul");
        var telefonoCliente = new Telefono("3201523600");
        var correoCliente = new Correo("rau.alzate@sofka.com.co");
        var cliente = new Cliente(clienteId, documentoCliente, nombreCliente, telefonoCliente, correoCliente);
        clientes.add(cliente);
        Set<Auto> listaAutos = new HashSet<>();
        var autoId = AutoId.of("11");
        var marca = new Marca("Mazda");
        var placa = new Placa("ZKY127");
        var auto = new Auto(autoId, marca, placa);
        listaAutos.add(auto);
        Set<ListaRepuestos> listaRepuestos = new HashSet<>();
        var repuesto1 = new ListaRepuestos("Bateria Mac Silver 36IST750MC");
        listaRepuestos.add(repuesto1);

        var event = new VendedorAsignado(vendedorId, nombreVendedor, telefonoVendedor, correoVendedor, clientes,
                listaAutos, listaRepuestos);

        var useCase = new AsignarVendedorUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var vendedorAsignado = (VendedorAsignado) events.get(0);
        Assertions.assertEquals("Natalia", vendedorAsignado.nombre().value());
    }
}