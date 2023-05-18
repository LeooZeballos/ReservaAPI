package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRolService extends IService<Rol> {
    Page<Rol> getAll(Pageable page, String nombre, String descripcion);
}
