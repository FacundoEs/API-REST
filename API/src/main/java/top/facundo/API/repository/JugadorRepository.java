package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.facundo.API.models.JugadorModel;
@Repository
public interface JugadorRepository extends JpaRepository<JugadorModel, Integer> {
}
