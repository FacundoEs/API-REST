package top.facundo.API.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.services.EquipoService;
import top.facundo.API.models.EquipoModel;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/equipo")
public class EquipoController {
    @Autowired
    EquipoService equipoService;
    @PostMapping("/insertar")
    public ResponseEntity<EquipoModel> insertarEquipo (@RequestBody EquipoModel equipoModel) throws BadRequestException {
        return ResponseEntity.ok(equipoService.crearEquipo(equipoModel));
    }
    @GetMapping("/mostrar")
    public ResponseEntity<List<EquipoModel>> obtenerTodosLosEquipos() {
        List<EquipoModel> equipos = equipoService.obtenerTodosEquipos();
        return ResponseEntity.ok(equipos);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<EquipoModel>> obtenerEquipoPorId(@PathVariable Integer id) {
        try {
            Optional<EquipoModel> equipo = equipoService.obtenerEquipoPorId(id);
            return ResponseEntity.ok(equipo);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<EquipoModel> actualizarEquipo(@PathVariable Integer id, @RequestBody EquipoModel equipoActualizado) {
        try {
            EquipoModel equipo = equipoService.actualizarEquipo(id, equipoActualizado);
            return ResponseEntity.ok(equipo);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEquipoPorId(@PathVariable Integer id) {
        try {
            equipoService.eliminarEquipoPorId(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
