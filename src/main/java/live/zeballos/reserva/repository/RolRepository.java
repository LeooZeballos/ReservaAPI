package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.Rol;
import live.zeballos.reserva.query.RolQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {
    default Page<Rol> findByParams(RolQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> rolPredicates = new ArrayList<>();
            if (queryParams.nombre() != null) {
                rolPredicates.add(builder.like(builder.lower(root.get("nombre")), "%" + queryParams.nombre().toLowerCase() + "%"));
            }
            if (queryParams.descripcion() != null) {
                rolPredicates.add(builder.like(builder.lower(root.get("descripcion")), "%" + queryParams.descripcion().toLowerCase() + "%"));
            }
            return builder.and(rolPredicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
