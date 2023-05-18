package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Reserva;
import live.zeballos.reserva.query.ReservaQueryParams;
import live.zeballos.reserva.repository.ReservaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static live.zeballos.reserva.util.Parser.parseIdList;

@Service
public class ReservaService implements IReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


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
