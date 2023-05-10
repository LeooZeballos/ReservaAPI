package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Recurso;
import live.zeballos.reserva.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService implements IRecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public List<Recurso> getAll() {
        return recursoRepository.findAll();
    }

    @Override
    public Recurso get(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }
    @Override
    public Recurso create(Recurso recurso) {
        return recursoRepository.saveAndFlush(recurso);
    }

    @Override
    public Recurso update(Long id, Recurso recurso) {
        Recurso recursoToUpdate = recursoRepository.findById(id).orElse(Recurso.builder().build());
        recursoToUpdate.setNombre(recurso.getNombre());
        recursoToUpdate.setDescripcion(recurso.getDescripcion());
        return recursoRepository.saveAndFlush(recursoToUpdate);
    }

    @Override
    public void delete(Long id) {
        recursoRepository.deleteById(id);
    }
}
