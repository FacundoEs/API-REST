package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.facundo.API.models.EquipoModel;

public interface EquipoRepository extends JpaRepository<EquipoModel, Integer> {
}
