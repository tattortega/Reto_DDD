package co.com.sofkau.taller.vendedor.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * Objeto de valor para DatosAuto
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-07-01
 * @since 1.0.0
 */
public class DatosAuto implements ValueObject<DatosAuto.Props> {

    private final String marca;
    private final String placa;

    public DatosAuto(String marca, String placa) {
        this.marca = Objects.requireNonNull(marca);
        this.placa = Objects.requireNonNull(placa);
        if (this.marca.isBlank()) {
            throw new IllegalArgumentException("El marca del carro no puede estar vacia");
        }
        if (this.placa.isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar vacia");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String marca() {
                return marca;
            }

            @Override
            public String placa() {
                return placa;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosAuto)) return false;
        DatosAuto datosAuto = (DatosAuto) o;
        return Objects.equals(marca, datosAuto.marca) && Objects.equals(placa, datosAuto.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, placa);
    }

    public interface Props {
        String marca();

        String placa();
    }

}
