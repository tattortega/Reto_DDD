package co.com.sofkau.taller.valuesgeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para Estado
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Estado implements ValueObject<Estado.Estados> {
    private final Estados value;

    public Estado(Estados value) {
        this.value = value;
    }

    @Override
    public Estados value() {
        return value;
    }

    public Estado finalizar() {
        return new Estado(Estados.FINALIZADO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return value == estado.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Estados {
        EMPEZADO, FINALIZADO
    }
}
