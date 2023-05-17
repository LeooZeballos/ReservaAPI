package live.zeballos.reserva.query;

import lombok.Getter;

@Getter
public class EspacioFisicoQueryParams {
    private final String nombre;
    private final Integer capacidad;

    private EspacioFisicoQueryParams(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private String nombre;
        private Integer capacidad;

        public Builder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder withCapacidad(Integer capacidad) {
            this.capacidad = capacidad;
            return this;
        }

        public EspacioFisicoQueryParams build() {
            return new EspacioFisicoQueryParams(nombre, capacidad);
        }
    }
}
