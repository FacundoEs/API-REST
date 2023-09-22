package com.facundo.FN.controllers;

import com.facundo.FN.models.JugadorModel;
import com.facundo.FN.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jugador")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    @PostMapping("/insertar")
    public ResponseEntity<JugadorModel> insertarJugador (@RequestBody JugadorModel jugadorModel){
        return ResponseEntity.ok(jugadorService.crearJugador(jugadorModel));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<JugadorModel>> buscarPorId(@PathVariable Integer id) {

        Optional<JugadorModel> jugadorModel = jugadorService.obtenerJugadorPorId(id);

        return ResponseEntity.ok(jugadorModel);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(jugadorService.eliminarJugador(id));
    }

    @PatchMapping("/modificar/{id}/{nombreNuevo}/{edadNuevo}")
    public ResponseEntity<String> modificarPorId(@PathVariable Integer id, @PathVariable String nombreNuevo, @PathVariable int edadNuevo) {
        return ResponseEntity.ok(jugadorService.actualizarJugador(id,nombreNuevo, edadNuevo));
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<JugadorModel>> traertodos() {
        return ResponseEntity.ok(jugadorService.obtenerTodosJugadores());
    }
}
