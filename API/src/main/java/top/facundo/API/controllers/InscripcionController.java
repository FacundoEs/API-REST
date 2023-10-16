package top.facundo.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.InscripcionModel;
import top.facundo.API.services.InscripcionService;

import java.util.List;

@RestController
@RequestMapping(value = "/inscripcion")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @PostMapping("/insertar")
    public ResponseEntity<InscripcionModel> insertarInscripcion (@RequestBody InscripcionModel inscripcionModel){
        return ResponseEntity.ok(inscripcionService.guardarInscripcion(inscripcionModel));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(inscripcionService.eliminarInscripcionPorId(id));
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<InscripcionModel>> traertodos() {
        return ResponseEntity.ok(inscripcionService.obtenerTodasLasInscripciones());
    }

}
