package co.com.sofkau.taller.vendedor.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.taller.vendedor.values.EntregaId;
import co.com.sofkau.taller.vendedor.values.Salida;
import co.com.sofkau.taller.vendedor.values.ValorTotal;


public class Entrega extends Entity<EntregaId> {
    protected Salida salida;
    protected ValorTotal valorTotal;

    public Entrega(EntregaId entityId, Salida salida, ValorTotal valorTotal) {
        super(entityId);
        this.salida = salida;
        this.valorTotal = valorTotal;
    }

    public void ingresarSalida(Salida salida){
        this.salida = salida;
    }
    public Salida salida() {
        return salida;
    }

    public void calcularValorTotal(ValorTotal valorTotal){
        this.valorTotal = valorTotal;
    }
    public ValorTotal valorTotal() {
        return valorTotal;
    }
}