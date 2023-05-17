package live.zeballos.reserva.repository;

import live.zeballos.reserva.model.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Long> {
    Page<EspacioFisico> findAllByNombreIgnoreCaseContains(Pageable page, String nombre);
    List<EspacioFisico> findAllByCapacidad(int capacidad);
    List<EspacioFisico> findAllByNombreIgnoreCaseContainsAndCapacidad(String nombre, int capacidad);
}
