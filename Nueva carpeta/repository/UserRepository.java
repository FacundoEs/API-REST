package com.Barberia.Barber.Repository;

import com.Barberia.Barber.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends MongoRepository<AppUser, String> {

    Optional<AppUser> findByEmail(String email);
}
