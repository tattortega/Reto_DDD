package co.com.sofkau.taller.valuesgeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class TipoDeTrabajo implements ValueObject<TipoDeTrabajo.Tipos> {

    private final Tipos value;

    public TipoDeTrabajo(Tipos value) {
        this.value = value;
    }

    @Override
    public Tipos value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDeTrabajo)) return false;
        TipoDeTrabajo that = (TipoDeTrabajo) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Tipos {
        REPARACION, GARANTIA
    }
}
