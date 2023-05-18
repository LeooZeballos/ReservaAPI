package live.zeballos.reserva.query;

import java.util.List;

@lombok.Builder
public record ClienteQueryParams(String nombre, String apellido, String nroTelefono, String email, Integer dni,
                                 List<Long> rolId) {
}
