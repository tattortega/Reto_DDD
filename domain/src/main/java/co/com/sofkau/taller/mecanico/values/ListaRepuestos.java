package co.com.sofkau.taller.mecanico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class ListaRepuestos implements ValueObject<String> {
    private final String value;

    public ListaRepuestos(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La lista de repuestos no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaRepuestos)) return false;
        ListaRepuestos that = (ListaRepuestos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
