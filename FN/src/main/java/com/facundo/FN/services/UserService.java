package com.facundo.FN.services;

import com.facundo.FN.models.UserModel;
import com.facundo.FN.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsuario(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Crear un objeto User con los datos del usuario
        return User.builder()
                .username(user.getUsuario())
                .password(user.getContrasena())
                .roles(user.getAppUserRole().toString()) // Puedes personalizar los roles según tu modelo
                .build();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
