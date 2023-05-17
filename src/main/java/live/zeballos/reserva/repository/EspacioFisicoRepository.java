package live.zeballos.reserva.repository;

import live.zeballos.reserva.model.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Long> {
    Page<EspacioFisico> findAllByNombreIgnoreCaseContains(Pageable page, String nombre);
    Page<EspacioFisico> findAllByCapacidad(Pageable page, int capacidad);
    Page<EspacioFisico> findAllByNombreIgnoreCaseContainsAndCapacidad(Pageable page, String nombre, int capacidad);
}
