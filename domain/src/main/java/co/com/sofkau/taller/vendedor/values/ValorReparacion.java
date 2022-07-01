package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para ValorReparacion
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class ValorReparacion implements ValueObject<Integer> {
    private final Integer value;

    public ValorReparacion(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 0) {
            throw new IllegalArgumentException("El valor de la reparacion no puede ser menor que cero");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValorReparacion)) return false;
        ValorReparacion that = (ValorReparacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
