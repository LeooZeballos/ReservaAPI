package live.zeballos.reserva.service;

import live.zeballos.reserva.error.ReservaAlreadyExistsException;
import live.zeballos.reserva.model.EspacioFisico;
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

    private final ReservaRepository repository;
    private final EstadoService estadoService;

    @Override
    public Page<Reserva> getAll(Pageable pageable, Integer duracion, String comentario, String clienteId, String motivoReserva, String estadoId, String motivoRechazo, String espacioFisicoId) {
        return repository.findByParams(
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
        return repository.findAll();
    }

    @Override
    public Page<Reserva> getAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Reserva get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Reserva create(Reserva reserva) {
        checkOverlappingReserva(reserva);
        reserva.setFechaHoraCreacion(LocalDateTime.now());
        reserva.setEstado(estadoService.get("Creado"));
        return repository.saveAndFlush(reserva);
    }

    @Override
    public Reserva update(Long id, Reserva reserva) {
        checkOverlappingReserva(reserva);
        reserva.setId(id);
        return repository.saveAndFlush(reserva);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void checkOverlappingReserva(Reserva reserva) {
        EspacioFisico espacioFisico = reserva.getEspacioFisico();
        LocalDateTime fechaHoraFin = reserva.getFechaHoraFin();
        LocalDateTime fechaHoraInicio = reserva.getFechaHoraInicio();
        Long id = reserva.getId();

        if (existsOverlappingReserva(espacioFisico, fechaHoraFin, fechaHoraInicio, id)) {
            throw new ReservaAlreadyExistsException("Ya existe una reserva para el espacio físico " +
                    espacioFisico.getNombre() + " en el horario " + fechaHoraInicio + " - " + fechaHoraFin);
        }
    }

    private boolean existsOverlappingReserva(EspacioFisico espacioFisico, LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, Long id) {
        return repository.existsByEspacioFisicoAndFechaHoraFinGreaterThanEqualAndFechaHoraInicioLessThanEqualAndIdNot(
                espacioFisico, fechaHoraFin, fechaHoraInicio, id);
    }

}
