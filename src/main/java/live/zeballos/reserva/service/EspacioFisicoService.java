package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.query.EspacioFisicoQueryParams;
import live.zeballos.reserva.repository.EspacioFisicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<EspacioFisico> getAll(Pageable page) {
        return espacioFisicoRepository.findAll(page);
    }

    @Override
    public Page<EspacioFisico> getAll(Pageable page, String nombre, Integer capacidad) {
        EspacioFisicoQueryParams queryParams = EspacioFisicoQueryParams.builder()
                .withNombre(nombre)
                .withCapacidad(capacidad)
                .build();
        return espacioFisicoRepository.findByParams(queryParams, page);
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
        espacioFisico.setId(id);
        return espacioFisicoRepository.saveAndFlush(espacioFisico);
    }

    @Override
    public void delete(Long id) {
        espacioFisicoRepository.deleteById(id);
    }

}
