package com.facundo.FN.services;

import com.facundo.FN.models.InscripcionModel;
import com.facundo.FN.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InscripcionService {

    private InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public InscripcionModel guardarInscripcion(InscripcionModel inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Optional<InscripcionModel> obtenerInscripcionPorId(Integer id) {
        return inscripcionRepository.findById(id);
    }

    public List<InscripcionModel> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public String eliminarInscripcionPorId(Integer id) {
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);

        String devuelve = "";

        if (inscripcion.isPresent()) {
            InscripcionModel inscripcionModel = inscripcion.get();
            devuelve = "Eliminate la inscripción.";
            inscripcionRepository.deleteById(id);
        }

        return devuelve;
    }
}
/*{"jugador": {"id":1}, "equipo":{"id":2}}*/