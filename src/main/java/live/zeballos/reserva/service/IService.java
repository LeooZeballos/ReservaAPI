package live.zeballos.reserva.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T get(Long id);
    T create(T t);
    T update(Long id, T t);
    void delete(Long id);
}
