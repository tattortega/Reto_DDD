package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Objeto de valor para Salida
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class Salida implements ValueObject<Salida.Props> {

    private final LocalDateTime horaSalida;
    private final LocalDate diaSalida;

    public Salida(LocalDateTime hora, LocalDate dia) {
        this.horaSalida = Objects.requireNonNull(hora);
        this.diaSalida = Objects.requireNonNull(dia);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalDateTime horaSalida() {
                return horaSalida;
            }

            @Override
            public LocalDate diaSalida() {
                return diaSalida;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salida)) return false;
        Salida salida = (Salida) o;
        return Objects.equals(horaSalida, salida.horaSalida) && Objects.equals(diaSalida, salida.diaSalida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaSalida, diaSalida);
    }

    public interface Props {
        LocalDateTime horaSalida();

        LocalDate diaSalida();
    }
}
