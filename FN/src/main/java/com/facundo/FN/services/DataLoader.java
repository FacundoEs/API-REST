package com.facundo.FN.services;

import com.facundo.FN.models.AppUser;
import com.facundo.FN.models.AppUserRole;
import com.facundo.FN.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
/*
    @Autowired
    AppUserService appUserService;
    public void run(ApplicationArguments args) {
        AppUser appUser = appUserService.loadUserByUsername(em);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("admin", "admin", "admin@gmail.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("user", "user", "user@gmail.com", hashedPassword2, AppUserRole.USER));
*/
    }
