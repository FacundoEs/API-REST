package com.facundo.FN.repository;

import com.facundo.FN.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByUsuario(String username);
}
