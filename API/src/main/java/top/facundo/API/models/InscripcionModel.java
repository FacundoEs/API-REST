package top.facundo.API.models;
import jakarta.persistence.*;
@Entity
@Table(name = "inscripciones")
public class InscripcionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private JugadorModel jugador;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private EquipoModel equipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JugadorModel getJugador() {
        return jugador;
    }

    public void setJugador(JugadorModel jugador) {
        this.jugador = jugador;
    }

    public EquipoModel getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoModel equipo) {
        this.equipo = equipo;
    }

    public InscripcionModel() {
    }
}
