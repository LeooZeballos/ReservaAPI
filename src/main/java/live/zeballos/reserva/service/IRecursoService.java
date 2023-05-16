package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Recurso;

import java.util.List;

public interface IRecursoService extends IService<Recurso> {
    List<Recurso> getByNombre(String nombre);
}
