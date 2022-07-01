package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para DatosEmpresa
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class DatosEmpresa implements ValueObject<DatosEmpresa.Props> {

    private final String nombreEmpresa;
    private final String descripcion;

    public DatosEmpresa(String nombreEmpresa, String descripcion) {
        this.nombreEmpresa = Objects.requireNonNull(nombreEmpresa);
        this.descripcion = Objects.requireNonNull(descripcion);

        if (this.nombreEmpresa.isBlank()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede estar vacio");
        }
        if (this.descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacio");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombreEmpresa() {
                return nombreEmpresa;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosEmpresa)) return false;
        DatosEmpresa that = (DatosEmpresa) o;
        return Objects.equals(nombreEmpresa, that.nombreEmpresa) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEmpresa, descripcion);
    }

    public interface Props {
        String nombreEmpresa();

        String descripcion();
    }
}
