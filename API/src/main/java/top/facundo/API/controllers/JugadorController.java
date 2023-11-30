package top.facundo.API.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.services.JugadorService;
import top.facundo.API.models.JugadorModel;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jugador")
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @PostMapping("/insertar")
    public ResponseEntity<JugadorModel> insertarJugador (@RequestBody JugadorModel jugadorModel) {
        JugadorModel nuevoJugador = jugadorService.crearJugador(jugadorModel);
        return ResponseEntity.ok(nuevoJugador);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<JugadorModel>> obtenerTodosLosJugadores() {
        List<JugadorModel> jugadores = jugadorService.obtenerTodosLosJugadores();
        return ResponseEntity.ok(jugadores);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<JugadorModel>> obtenerJugadorPorId(@PathVariable Integer id) {
        try {
            Optional<JugadorModel> jugador = jugadorService.obtenerJugadorPorId(id);
            return ResponseEntity.ok(jugador);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<JugadorModel> actualizarJugador(@PathVariable Integer id, @RequestBody JugadorModel jugadorActualizado) {
        try {
            JugadorModel jugador = jugadorService.actualizarJugador(id, jugadorActualizado);
            return ResponseEntity.ok(jugador);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarJugadorPorId(@PathVariable Integer id) {
        try {
            jugadorService.eliminarJugadorPorId(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
