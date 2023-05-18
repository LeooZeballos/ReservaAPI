package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Rol;
import live.zeballos.reserva.query.RolQueryParams;
import live.zeballos.reserva.repository.RolRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Page<Rol> getAll(Pageable page) {
        return rolRepository.findAll(page);
    }

    @Override
    public Page<Rol> getAll(Pageable page, String nombre, String descripcion) {
        return rolRepository.findByParams(
                RolQueryParams.builder()
                        .nombre(nombre)
                        .descripcion(descripcion)
                        .build(),
                page
        );
    }

    @Override
    public Rol get(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol create(Rol rol) {
        return rolRepository.saveAndFlush(rol);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        rol.setId(id);
        return rolRepository.saveAndFlush(rol);
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

}
