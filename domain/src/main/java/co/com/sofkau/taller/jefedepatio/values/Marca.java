package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Marca implements ValueObject<String> {
    private final String value;

    public Marca(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca)) return false;
        Marca marca = (Marca) o;
        return Objects.equals(value, marca.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
