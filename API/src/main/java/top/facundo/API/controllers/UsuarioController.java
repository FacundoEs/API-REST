package top.facundo.API.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.services.UsuarioService;
import top.facundo.API.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            UsuarioModel nuevoUsuario = usuarioService.crearUsuario(usuarioModel);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuarioPorId(@PathVariable Integer id) {
        try {
            Optional<UsuarioModel> usuario = usuarioService.obtenerUsuarioPorId(id);
            return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<UsuarioModel>> obtenerTodosLosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.obtenerTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuarioActualizado) {
        try {
            UsuarioModel usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(usuario);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuarioPorId(@PathVariable Integer id) {
        try {
            usuarioService.eliminarUsuarioPorId(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ingresar")
    public ResponseEntity<?> loginUsuario(@RequestParam String nombreUsuario, @RequestParam String contrasena) {
        try {
            UsuarioModel usuarioAutenticado = usuarioService.ingresarUsuario(nombreUsuario, contrasena);
            return ResponseEntity.ok(usuarioAutenticado);
        } catch (ResourceNotFoundException | BadRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
