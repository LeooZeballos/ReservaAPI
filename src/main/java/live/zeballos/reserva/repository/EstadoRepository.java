package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.Estado;
import live.zeballos.reserva.query.EstadoQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>, JpaSpecificationExecutor<Estado> {
    default Page<Estado> findByParams(EstadoQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> estadoPredicates = new ArrayList<>();
            if (queryParams.nombre() != null) {
                estadoPredicates.add(builder.like(builder.lower(root.get("nombre")), "%" + queryParams.nombre().toLowerCase() + "%"));
            }
            if (queryParams.descripcion() != null) {
                estadoPredicates.add(builder.like(builder.lower(root.get("descripcion")), "%" + queryParams.descripcion().toLowerCase() + "%"));
            }
            if (queryParams.color() != null) {
                estadoPredicates.add(builder.like(builder.lower(root.get("color")), "%" + queryParams.color().toLowerCase() + "%"));
            }
            return builder.and(estadoPredicates.toArray(new Predicate[0]));
        }, pageable);
    }

    Optional<Estado> findByNombre(String nombre);
}
