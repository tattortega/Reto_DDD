package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para DatosCliente
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
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
