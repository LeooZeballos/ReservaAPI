package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEspacioFisicoService extends IService<EspacioFisico> {
    Page<EspacioFisico> getAll(Pageable page, String nombre, Integer capacidad, String descripcion, Boolean habilitado);
}
