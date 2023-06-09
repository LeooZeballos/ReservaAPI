package live.zeballos.reserva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity(name = "reserva")
public class Reserva extends ObjetoDB {

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    /**
     * The duration of the reservation in minutes
     */
    @Column(name = "fecha_hora_fin", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "comentario", nullable = true)
    private String comentario;

    @Column(name = "fecha_hora_creacion", nullable = false)
    private LocalDateTime fechaHoraCreacion;

    @ManyToOne
    private Cliente cliente;

    @Column(name = "motivo_reserva", nullable = false)
    private String motivoReserva;

    @ManyToOne
    private Estado estado;

    @Column(name = "motivo_rechazo", nullable = true)
    private String motivoRechazo;

    @ManyToOne
    private EspacioFisico espacioFisico;

    public long getDuracion() {
        return ChronoUnit.MINUTES.between(fechaHoraInicio, fechaHoraFin);
    }

}
