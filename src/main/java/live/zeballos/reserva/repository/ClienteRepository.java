package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.Cliente;
import live.zeballos.reserva.query.ClienteQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
    default Page<Cliente> findByParams(ClienteQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> clientePredicates = new ArrayList<>();
            if (queryParams.nombre() != null) {
                clientePredicates.add(builder.like(builder.lower(root.get("nombre")), "%" + queryParams.nombre().toLowerCase() + "%"));
            }
            if (queryParams.apellido() != null) {
                clientePredicates.add(builder.like(builder.lower(root.get("apellido")), "%" + queryParams.apellido().toLowerCase() + "%"));
            }
            if (queryParams.nroTelefono() != null) {
                clientePredicates.add(builder.like(builder.lower(root.get("nroTelefono")), "%" + queryParams.nroTelefono().toLowerCase() + "%"));
            }
            if (queryParams.email() != null) {
                clientePredicates.add(builder.like(builder.lower(root.get("email")), "%" + queryParams.email().toLowerCase() + "%"));
            }
            if (queryParams.dni() != null) {
                clientePredicates.add(builder.equal(root.get("dni"), queryParams.dni()));
            }
            if (queryParams.rolId() != null) {
                clientePredicates.add(root.join("rol").get("id").in(queryParams.rolId()));
            }
            return builder.and(clientePredicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
