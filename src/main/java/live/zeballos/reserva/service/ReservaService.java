package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Reserva;
import live.zeballos.reserva.query.ReservaQueryParams;
import live.zeballos.reserva.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static live.zeballos.reserva.util.Parser.parseIdList;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

    private final ReservaRepository reservaRepository;
    private final EstadoService estadoService;

    @Override
    public Page<Reserva> getAll(Pageable pageable, Integer duracion, String comentario, String clienteId, String motivoReserva, String estadoId, String motivoRechazo, String espacioFisicoId) {
        return reservaRepository.findByParams(
                ReservaQueryParams.builder()
                        .duracion(duracion)
                        .comentario(comentario)
                        .clienteId(parseIdList(clienteId))
                        .motivoReserva(motivoReserva)
                        .estadoId(parseIdList(estadoId))
                        .motivoRechazo(motivoRechazo)
                        .espacioFisicoId(parseIdList(espacioFisicoId))
                        .build(),
                pageable
        );
    }

    @Override
    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Page<Reserva> getAll(Pageable page) {
        return reservaRepository.findAll(page);
    }

    @Override
    public Reserva get(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva create(Reserva reserva) {
        // First, we check if there is another reserva on the same date and time
        // if (!reservaRepository.existsOverlappingReserva(
        //         reserva.getEspacioFisico(),
        //         reserva.getFechaHoraFin(),
        //         reserva.getFechaHoraInicio()
        // )) {
        //     throw new RuntimeException("Ya existe una reserva en el mismo espacio físico en el mismo horario");
        // }

        // Set the creation date and time and the state
        reserva.setFechaHoraCreacion(LocalDateTime.now());
        reserva.setEstado(estadoService.get("Creado"));

        // Save the reserva and return it
        return reservaRepository.saveAndFlush(reserva);
    }

    @Override
    public Reserva update(Long id, Reserva reserva) {
        reserva.setId(id);
        return reservaRepository.saveAndFlush(reserva);
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
