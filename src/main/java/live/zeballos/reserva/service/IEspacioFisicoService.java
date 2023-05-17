package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEspacioFisicoService extends IService<EspacioFisico> {
    Page<EspacioFisico> getByNombre(Pageable page, String nombre);
    List<EspacioFisico> getByCapacidad(int capacidad);
    List<EspacioFisico> getByNombreAndCapacidad(String nombre, int capacidad);
}
