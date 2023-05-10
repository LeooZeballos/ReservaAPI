package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.repository.EspacioFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioFisicoService implements IEspacioFisicoService {

    private final EspacioFisicoRepository espacioFisicoRepository;

    public EspacioFisicoService(EspacioFisicoRepository espacioFisicoRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    @Override
    public List<EspacioFisico> getAll() {
        return espacioFisicoRepository.findAll();
    }

    @Override
    public EspacioFisico get(Long id) {
        return espacioFisicoRepository.findById(id).orElse(null);
    }

    @Override
    public EspacioFisico create(EspacioFisico espacioFisico) {
        return espacioFisicoRepository.saveAndFlush(espacioFisico);
    }

    @Override
    public EspacioFisico update(Long id, EspacioFisico espacioFisico) {
        return espacioFisicoRepository.saveAndFlush(espacioFisico);
    }

    @Override
    public void delete(Long id) {
        espacioFisicoRepository.deleteById(id);
    }
}
