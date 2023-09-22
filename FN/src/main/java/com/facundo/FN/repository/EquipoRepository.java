package com.facundo.FN.repository;
import com.facundo.FN.models.EquipoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<EquipoModel, Integer> {
}