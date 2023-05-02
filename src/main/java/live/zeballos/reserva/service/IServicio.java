package live.zeballos.reserva.service;

import live.zeballos.reserva.model.Recurso;

import java.util.List;

public interface IServicio<T> {
    List<T> getAll();
    T get(Long id);
    Recurso create(T t);
    Recurso update(T t);
    Recurso update(Long id, T t);
    void delete(T t);
    void delete(Long id);
}
