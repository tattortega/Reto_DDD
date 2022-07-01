package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para MetodoPago
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class MetodoPago implements ValueObject<MetodoPago.Metodo> {
    private final Metodo value;

    public MetodoPago(Metodo value) {
        this.value = value;
    }

    @Override
    public Metodo value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetodoPago)) return false;
        MetodoPago that = (MetodoPago) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Metodo {
        EFECTIVO, TRANSFERENCIA
    }
}
