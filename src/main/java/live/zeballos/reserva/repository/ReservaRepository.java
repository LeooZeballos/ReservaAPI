package live.zeballos.reserva.repository;

import jakarta.persistence.criteria.Predicate;
import live.zeballos.reserva.model.EspacioFisico;
import live.zeballos.reserva.model.Reserva;
import live.zeballos.reserva.query.ReservaQueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva> {
    default Page<Reserva> findByParams(ReservaQueryParams queryParams, Pageable pageable) {
        return findAll((root, query, builder) -> {
            List<Predicate> reservaPredicates = new ArrayList<>();
            if (queryParams.duracion() != null) {
                reservaPredicates.add(builder.equal(root.get("duracion"), queryParams.duracion()));
            }
            if (queryParams.comentario() != null) {
                reservaPredicates.add(builder.like(builder.lower(root.get("comentario")), "%" + queryParams.comentario().toLowerCase() + "%"));
            }
            if (queryParams.clienteId() != null && !queryParams.clienteId().isEmpty()) {
                reservaPredicates.add(root.join("cliente").get("id").in(queryParams.clienteId()));
            }
            if (queryParams.motivoReserva() != null) {
                reservaPredicates.add(builder.like(builder.lower(root.get("motivoReserva")), "%" + queryParams.motivoReserva().toLowerCase() + "%"));
            }
            if (queryParams.estadoId() != null && !queryParams.estadoId().isEmpty()) {
                reservaPredicates.add(root.join("estado").get("id").in(queryParams.estadoId()));
            }
            if (queryParams.motivoRechazo() != null) {
                reservaPredicates.add(builder.like(builder.lower(root.get("motivoRechazo")), "%" + queryParams.motivoRechazo().toLowerCase() + "%"));
            }
            if (queryParams.espacioFisicoId() != null && !queryParams.espacioFisicoId().isEmpty()) {
                reservaPredicates.add(root.join("espacioFisico").get("id").in(queryParams.espacioFisicoId()));
            }
            return builder.and(reservaPredicates.toArray(new Predicate[0]));
        }, pageable);
    }

    boolean existsByEspacioFisicoAndFechaHoraFinGreaterThanEqualAndFechaHoraInicioLessThanEqualAndIdNot(EspacioFisico espacioFisico, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Long id);
}
