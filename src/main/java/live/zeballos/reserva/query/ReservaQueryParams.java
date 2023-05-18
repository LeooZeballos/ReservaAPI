package live.zeballos.reserva.query;

import java.util.List;

@lombok.Builder
public record ReservaQueryParams(
        Integer duracion,
        String comentario,
        List<Long> clienteId,
        String motivoReserva,
        List<Long> estadoId,
        String motivoRechazo,
        List<Long> espacioFisicoId
) {
}
