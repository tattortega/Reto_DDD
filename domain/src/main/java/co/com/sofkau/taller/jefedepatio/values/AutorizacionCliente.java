package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para Autorizacion del Cliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
