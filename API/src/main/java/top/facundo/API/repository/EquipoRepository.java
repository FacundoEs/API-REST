package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.facundo.API.models.EquipoModel;

import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoModel, Integer> {
    Optional<EquipoModel> findByNombre(String nombre);
}
