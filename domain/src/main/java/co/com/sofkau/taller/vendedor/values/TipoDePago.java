package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDePago implements ValueObject<TipoDePago.Pago> {
    private final Pago value;

    public TipoDePago(Pago value) {
        this.value = value;
    }

    @Override
    public Pago value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDePago)) return false;
        TipoDePago tipoDePago = (TipoDePago) o;
        return value == tipoDePago.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Pago {
        CREDITO, CONTADO
    }
}
