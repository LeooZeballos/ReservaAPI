package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Recurso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRecursoService extends IService<Recurso> {
    Page<Recurso> getAll(Pageable page, String nombre);
}
