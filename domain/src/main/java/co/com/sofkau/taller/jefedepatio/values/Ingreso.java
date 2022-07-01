package co.com.sofkau.taller.jefedepatio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class Ingreso implements ValueObject<Ingreso.Props> {

    private final LocalDateTime horaIngreso;
    private final LocalDate diaIngreso;

    public Ingreso(LocalDateTime hora, LocalDate dia) {
        this.horaIngreso = Objects.requireNonNull(hora);
        this.diaIngreso = Objects.requireNonNull(dia);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalDateTime horaIngreso() {
                return horaIngreso;
            }

            @Override
            public LocalDate diaIngreso() {
                return diaIngreso;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingreso)) return false;
        Ingreso ingreso = (Ingreso) o;
        return Objects.equals(horaIngreso, ingreso.horaIngreso) && Objects.equals(diaIngreso, ingreso.diaIngreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horaIngreso, diaIngreso);
    }

    public interface Props {
        LocalDateTime horaIngreso();

        LocalDate diaIngreso();
    }
}
