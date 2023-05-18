package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.Recurso;
import live.zeballos.reserva.query.RecursoQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long>, JpaSpecificationExecutor<Recurso> {
    default Page<Recurso> findByParams(RecursoQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (queryParams.nombre() != null) {
                predicates.add(builder.like(builder.lower(root.get("nombre")), "%" + queryParams.nombre().toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
