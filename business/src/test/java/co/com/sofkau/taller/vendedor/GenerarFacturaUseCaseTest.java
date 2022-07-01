package co.com.sofkau.taller.vendedor;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.jefedepatio.entities.Auto;
import co.com.sofkau.taller.jefedepatio.entities.Cliente;
import co.com.sofkau.taller.jefedepatio.values.*;
import co.com.sofkau.taller.mecanico.values.ListaRepuestos;
import co.com.sofkau.taller.valuesgeneric.Correo;
import co.com.sofkau.taller.valuesgeneric.Nombre;
import co.com.sofkau.taller.valuesgeneric.Telefono;
import co.com.sofkau.taller.vendedor.events.*;
import co.com.sofkau.taller.vendedor.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerarFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    private final Nombre nombreVendedor = new Nombre("Natalia");
    private final Telefono telefonoVendedor = new Telefono("3135687485");
    private final Correo correoVendedor = new Correo("natalia@chevrocentro.com");
    private final Set<Cliente> clientes = new HashSet<>();
    private final ClienteId clienteId = ClienteId.of("142");
    private final Documento documentoCliente = new Documento("109563625");
    private final Nombre nombreCliente = new Nombre("Raul");
    private final Telefono telefonoCliente = new Telefono("3201523600");
    private final Correo correoCliente = new Correo("raul.alzate@sofka.com.co");
    private final Set<Auto> listaAutos = new HashSet<>();
    private final AutoId autoId = AutoId.of("11");
    private final Marca marca = new Marca("Mazda");
    private final Placa placa = new Placa("ZKY127");
    private final Set<ListaRepuestos> listaRepuestos = new HashSet<>();
    private final ValorCompra valorCompra = new ValorCompra(350000);
    private final ValorReparacion valorReparacion = new ValorReparacion(80000);


    @Test
    void generarFactura() {
        var cliente = new Cliente(clienteId, documentoCliente, nombreCliente, telefonoCliente, correoCliente);
        clientes.add(cliente);

        var auto = new Auto(autoId, marca, placa);
        listaAutos.add(auto);

        var repuesto1 = new ListaRepuestos("Bateria Mac Silver 36IST750MC");
        listaRepuestos.add(repuesto1);

        var vendedorId = VendedorId.of("03");

        var event = createTriggeredEventWith(vendedorId);

        var useCase = new GenerarFacturaUseCase();

        when(repository.getEventsBy(vendedorId.value())).thenReturn(eventStored(vendedorId));
        useCase.addRepository(repository);

        var events = executor(vendedorId, event, useCase);

        var factura = (FacturaGenerada) events.get(0);
        Assertions.assertEquals("Raul", factura.datosCliente().value());
        var taller = factura.datosEmpresas().stream().iterator().next().value().nombreEmpresa();
        Assertions.assertEquals("Taller Automotriz Chevrocentro", taller);
        Assertions.assertEquals(430000, factura.valorTotal().value());
    }

    private FacturaGenerada createTriggeredEventWith(VendedorId vendedorId) {

        var facturaId = FacturaId.of("042366");
        var datosCliente = new DatosCliente(nombreCliente.value());
        Set<DatosEmpresa> datosEmpresa = new HashSet<>();
        datosEmpresa.add(new DatosEmpresa("Taller Automotriz Chevrocentro", "Servicio mecanico"));
        Set<DatosAuto> datosAuto = new HashSet<>();
        datosAuto.add(new DatosAuto(marca.value(), placa.value()));
        Set<ListaRepuestos> listaRepuestos = new HashSet<>();
        listaRepuestos.add(new ListaRepuestos("Bateria Mac Silver 36IST750MC"));
        var valorTotal = new ValorTotal(valorCompra, valorReparacion);
        var event = new FacturaGenerada(facturaId, vendedorId, datosCliente, datosEmpresa, datosAuto,
                listaRepuestos, valorCompra, valorReparacion, valorTotal);

        event.setAggregateRootId(vendedorId.value());
        return event;
    }

    private List<DomainEvent> eventStored(VendedorId vendedorId) {
        var tipoDePago = new TipoDePago(TipoDePago.Pago.CONTADO);
        var metodoDePago = new MetodoPago(MetodoPago.Metodo.EFECTIVO);
        var salida = new Salida(LocalDateTime.now(), LocalDate.now());
        var valorTotal = new ValorTotal(valorCompra, valorReparacion);

        return List.of(
                new VendedorAsignado(vendedorId, nombreVendedor, telefonoVendedor, correoVendedor, clientes, listaAutos, listaRepuestos),
                new CompraGenerada(vendedorId, valorCompra),
                new VentaGenerada(vendedorId, tipoDePago, metodoDePago, valorReparacion),
                new EntregaRealizada(vendedorId, salida, valorTotal)
        );
    }

    private List<DomainEvent> executor(VendedorId vendedorId, FacturaGenerada event, GenerarFacturaUseCase useCase) {
        return UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(vendedorId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
    }
}