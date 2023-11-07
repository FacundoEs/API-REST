package com.facundo.FN.controllers;

import com.facundo.FN.models.UserModel;
import com.facundo.FN.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/crear")
    public UserModel createUser(@RequestBody UserModel user) {
        // Aquí puedes realizar validaciones u otras operaciones antes de guardar el usuario
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public UserModel getUserById(@PathVariable Integer userId) {
        return userService.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @GetMapping("/listar")
    public List<UserModel> getAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
