package live.zeballos.reserva.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity(name = "cliente")
public class Cliente extends ObjetoDB {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "nro_telefono", nullable = false)
    private String nroTelefono;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dni", nullable = false)
    private int dni;

    @ManyToOne
    private Rol rol;
}
