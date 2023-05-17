package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEspacioFisicoService extends IService<EspacioFisico> {
    Page<EspacioFisico> getByNombre(Pageable page, String nombre);
    Page<EspacioFisico> getByCapacidad(Pageable page, int capacidad);
    Page<EspacioFisico> getByNombreAndCapacidad(Pageable page, String nombre, int capacidad);
}
