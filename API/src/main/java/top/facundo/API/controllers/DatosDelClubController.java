package top.facundo.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.facundo.API.models.DatosDelClubModel;
import top.facundo.API.services.DatosDelClubService;

import java.util.List;

@RestController
@RequestMapping("/datos-del-club")
public class DatosDelClubController {

    private final DatosDelClubService datosDelClubService;

    @Autowired
    public DatosDelClubController(DatosDelClubService datosDelClubService) {
        this.datosDelClubService = datosDelClubService;
    }

    @PostMapping
    public ResponseEntity<DatosDelClubModel> crearDatosDelClub(@RequestBody DatosDelClubModel datosDelClub) {
        try {
            DatosDelClubModel nuevoDatosDelClub = datosDelClubService.crearDatosDelClub(datosDelClub);
            return new ResponseEntity<>(nuevoDatosDelClub, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<DatosDelClubModel>> obtenerTodosDatosDelClub() {
        List<DatosDelClubModel> datosDelClubList = datosDelClubService.obtenerTodosDatosDelClub();
        return new ResponseEntity<>(datosDelClubList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosDelClubModel> actualizarDatosDelClub(@PathVariable Integer id, @RequestBody DatosDelClubModel datosActualizados) {
        try {
            DatosDelClubModel datosDelClubActualizado = datosDelClubService.actualizarDatosDelClub(id, datosActualizados);
            return new ResponseEntity<>(datosDelClubActualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

