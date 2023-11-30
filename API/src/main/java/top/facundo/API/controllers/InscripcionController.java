package top.facundo.API.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.services.InscripcionService;
import top.facundo.API.models.InscripcionModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/inscripcion")
public class InscripcionController {
    @Autowired
    InscripcionService inscripcionService;

    @PostMapping("/insertar")
    public ResponseEntity<InscripcionModel> insertarInscripcion (@RequestBody InscripcionModel inscripcionModel) throws BadRequestException {
        InscripcionModel nuevaInscripcion = inscripcionService.guardarInscripcion(inscripcionModel);
        return ResponseEntity.ok(nuevaInscripcion);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<InscripcionModel>> obtenerTodasLasInscripciones() {
        List<InscripcionModel> inscripciones = inscripcionService.obtenerTodasLasInscripciones();
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<InscripcionModel>> obtenerInscripcionPorId(@PathVariable Integer id) {
        try {
            Optional<InscripcionModel> inscripcion = inscripcionService.obtenerInscripcionPorId(id);
            return ResponseEntity.ok(inscripcion);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarInscripcionPorId(@PathVariable Integer id) {
        try {
            inscripcionService.eliminarInscripcionPorId(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
