package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.query.EspacioFisicoQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Long>, JpaSpecificationExecutor<EspacioFisico> {
    default Page<EspacioFisico> findByParams(EspacioFisicoQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (queryParams.getNombre() != null) {
                predicates.add(builder.like(builder.lower(root.get("nombre")), "%" + queryParams.getNombre().toLowerCase() + "%"));
            }
            if (queryParams.getCapacidad() != null) {
                predicates.add(builder.equal(root.get("capacidad"), queryParams.getCapacidad()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
