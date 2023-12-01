package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.facundo.API.models.DatosDelClubModel;

public interface DatosDelClubRepository extends JpaRepository<DatosDelClubModel, Integer> {
}
