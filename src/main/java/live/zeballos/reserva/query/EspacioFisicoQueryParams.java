package live.zeballos.reserva.query;

@lombok.Builder
public record EspacioFisicoQueryParams(String nombre, Integer capacidad, String descripcion, Boolean habilitado) {
}
