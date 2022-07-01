package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class AutorizacionCliente implements ValueObject<AutorizacionCliente.Autorizacion> {
    private final Autorizacion value;

    public AutorizacionCliente(Autorizacion value) {
        this.value = value;
    }

    @Override
    public Autorizacion value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutorizacionCliente)) return false;
        AutorizacionCliente that = (AutorizacionCliente) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public enum Autorizacion {
        AUTORIZADO, DESAUTORIZADO
    }
}
