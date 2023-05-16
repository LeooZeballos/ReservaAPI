package live.zeballos.reserva.repository;

import live.zeballos.reserva.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    List<Recurso> findAllByNombreIgnoreCaseContains(String nombre);


}
