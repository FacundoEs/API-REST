package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.facundo.API.models.JugadorModel;

public interface JugadorRepository extends JpaRepository<JugadorModel, Integer> {
}
