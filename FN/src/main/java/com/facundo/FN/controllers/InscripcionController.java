package com.facundo.FN.controllers;

import com.facundo.FN.models.InscripcionModel;
import com.facundo.FN.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(inscripcionService.eliminarInscripcionPorId(id));
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<InscripcionModel>> traertodos() {
        return ResponseEntity.ok(inscripcionService.obtenerTodasLasInscripciones());
    }

}
