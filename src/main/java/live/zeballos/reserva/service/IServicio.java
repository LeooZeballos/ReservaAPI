package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Recurso;

import java.util.List;

public interface IServicio<T> {
    List<T> getAll();
    T get(Long id);
    T create(T t);
    T update(Long id, T t);
    void delete(Long id);
}
