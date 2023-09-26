package com.facundo.FN.controllers;

import com.facundo.FN.exceptions.ResourceNotFoundException;
import com.facundo.FN.models.EquipoModel;
import com.facundo.FN.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/equipo")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @PostMapping("/insertar")
    public ResponseEntity<EquipoModel> insertarEquipo (@RequestBody EquipoModel equipoModel){
        return ResponseEntity.ok(equipoService.crearEquipo(equipoModel));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id) throws ResourceNotFoundException{
        return ResponseEntity.ok(equipoService.eliminarEquipoPorId(id));
    }

    @PatchMapping("/modificar/{id}/{nombreNuevo}")
    public ResponseEntity<String> modificarPorId(@PathVariable Integer id, @PathVariable String nombreNuevo) throws ResourceNotFoundException {
        return ResponseEntity.ok(equipoService.actualizarEquipo(id,nombreNuevo));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<EquipoModel>> buscarPorId(@PathVariable Integer id) {

        Optional<EquipoModel> equipoModel = equipoService.obtenerEquipoPorId(id);

        return ResponseEntity.ok(equipoModel);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<EquipoModel>> traertodos() {
        return ResponseEntity.ok(equipoService.obtenerTodosEquipos());
    }

}
