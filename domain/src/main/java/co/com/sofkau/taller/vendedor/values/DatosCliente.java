package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosCliente implements ValueObject<String> {

    private final String nombre;

    public DatosCliente(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}
