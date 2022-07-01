package co.com.sofkau.taller.valuesgeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Estado implements ValueObject<Estado.Estados> {
    private Estados value;

    public Estado(Estados value) {
        this.value = value;
    }

    @Override
    public Estados value() {
        return value;
    }

    public Estado finalizar() {
        return new co.com.sofkau.taller.valuesgeneric.Estado(co.com.sofkau.taller.valuesgeneric.Estado.Estados.FINALIZADO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof co.com.sofkau.taller.valuesgeneric.Estado)) return false;
        co.com.sofkau.taller.valuesgeneric.Estado estado = (co.com.sofkau.taller.valuesgeneric.Estado) o;
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
