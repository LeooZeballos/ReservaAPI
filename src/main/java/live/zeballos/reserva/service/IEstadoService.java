package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEstadoService extends IService<Estado> {
    Page<Estado> getAll(Pageable page, String nombre, String descripcion, String color);
}
