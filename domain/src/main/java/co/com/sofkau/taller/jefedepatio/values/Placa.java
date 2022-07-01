package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para Placa
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Placa implements ValueObject<String> {
    private final String value;

    public Placa(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Placa)) return false;
        Placa placa = (Placa) o;
        return Objects.equals(value, placa.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
