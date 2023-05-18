package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Estado;
import live.zeballos.reserva.query.EstadoQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import live.zeballos.reserva.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService implements IEstadoService {
    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Estado> getAll() {
        return estadoRepository.findAll();
    }

    @Override
    public Page<Estado> getAll(Pageable page) {
        return estadoRepository.findAll(page);
    }

    @Override
    public Page<Estado> getAll(Pageable page, String nombre, String descripcion, String color) {
        return estadoRepository.findByParams(
                EstadoQueryParams.builder()
                        .nombre(nombre)
                        .descripcion(descripcion)
                        .color(color)
                        .build(),
                page
        );
    }

    @Override
    public Estado get(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    @Override
    public Estado create(Estado estado) {
        return estadoRepository.saveAndFlush(estado);
    }

    @Override
    public Estado update(Long id, Estado estado) {
        estado.setId(id);
        return estadoRepository.saveAndFlush(estado);
    }

    @Override
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

}
