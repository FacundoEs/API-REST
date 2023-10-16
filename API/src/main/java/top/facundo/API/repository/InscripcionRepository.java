package top.facundo.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.facundo.API.models.InscripcionModel;

public interface InscripcionRepository extends JpaRepository<InscripcionModel, Integer> {
}
