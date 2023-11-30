package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.facundo.API.models.EquipoModel;
import top.facundo.API.models.InscripcionModel;
import top.facundo.API.models.JugadorModel;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionModel, Integer> {
    List<InscripcionModel> findByJugadorAndEquipo(JugadorModel jugador, EquipoModel equipo);
}
