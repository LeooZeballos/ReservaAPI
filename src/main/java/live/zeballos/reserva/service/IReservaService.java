package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReservaService extends IService<Reserva> {
    Page<Reserva> getAll(Pageable pageable, Integer duracion, String comentario, String clienteId, String motivoReserva, String estadoId, String motivoRechazo, String espacioFisicoId);
}
