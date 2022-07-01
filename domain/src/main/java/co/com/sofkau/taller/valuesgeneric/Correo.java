package co.com.sofkau.taller.valuesgeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Objeto de valor para Correo
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Correo implements ValueObject<String> {
    private final String value;

    public Correo(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(value);

        if (!mather.find()) {
            throw new IllegalArgumentException("El email ingresado es inválido");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
