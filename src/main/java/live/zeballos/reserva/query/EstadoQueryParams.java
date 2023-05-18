package live.zeballos.reserva.query;

@lombok.Builder
public record EstadoQueryParams(String nombre, String descripcion, String color) {
}
