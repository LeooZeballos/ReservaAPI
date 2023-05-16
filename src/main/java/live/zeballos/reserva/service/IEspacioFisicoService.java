package live.zeballos.reserva.service;

import live.zeballos.reserva.model.EspacioFisico;

import java.util.List;

public interface IEspacioFisicoService extends IService<EspacioFisico> {
    List<EspacioFisico> getByNombre(String nombre);
    List<EspacioFisico> getByCapacidad(int capacidad);
    List<EspacioFisico> getByNombreAndCapacidad(String nombre, int capacidad);
}
