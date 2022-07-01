package co.com.sofkau.taller.vendedor.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.taller.vendedor.values.Salida;
import co.com.sofkau.taller.vendedor.values.ValorTotal;
import co.com.sofkau.taller.vendedor.values.VendedorId;


public class EntregaRealizada extends DomainEvent {
    private final VendedorId vendedorId;
    private final Salida salida;
    private final ValorTotal valorTotal;

    public EntregaRealizada(VendedorId vendedorId, Salida salida, ValorTotal valorTotal) {
        super("co.com.sofkau.taller.vendedor.EntregaRealizada");
        this.vendedorId = vendedorId;
        this.salida = salida;
        this.valorTotal = valorTotal;
    }

    public VendedorId vendedorId() {
        return vendedorId;
    }

    public Salida salida() {
        return salida;
    }

    public ValorTotal valorTotal() {
        return valorTotal;
    }
}
