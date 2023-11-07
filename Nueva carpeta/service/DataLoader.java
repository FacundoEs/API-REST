/*
package com.Barberia.Barber.Service;

import com.Barberia.Barber.Model.AppUser;
import com.Barberia.Barber.Model.AppUserRole;
import com.Barberia.Barber.Model.Cliente;
import com.Barberia.Barber.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
   */
/* @Autowired
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
   *//*

}
}
*/
