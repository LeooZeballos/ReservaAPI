package live.zeballos.reserva.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    Page<T> getAll(Pageable page);
    T get(Long id);
    T create(T t);
    T update(Long id, T t);
    void delete(Long id);
}
