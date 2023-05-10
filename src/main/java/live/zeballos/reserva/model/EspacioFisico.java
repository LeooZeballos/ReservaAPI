package live.zeballos.reserva.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity(name = "espacio_fisico")
public class EspacioFisico extends ObjetoDB {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Recurso> recursos;

    @Column(name = "habilitado", nullable = false)
    private boolean habilitado;

    /**
     * Add a recurso to the list of recursos
     *
     * @param recurso
     */
    public void addRecurso(Recurso recurso) {
        this.recursos.add(recurso);
    }

    /**
     * Remove a recurso from the list of recursos
     *
     * @param recurso
     */
    public void removeRecurso(Recurso recurso) {
        this.recursos.remove(recurso);
    }

}
