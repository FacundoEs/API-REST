package top.facundo.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.InscripcionModel;
import top.facundo.API.repository.InscripcionRepository;

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

    public String eliminarInscripcionPorId(Integer id) throws ResourceNotFoundException {
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);

        String devuelve = "";

        if (inscripcion.isPresent()) {
            InscripcionModel inscripcionModel = inscripcion.get();
            devuelve = "Eliminate la inscripción.";
            inscripcionRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe esa inscripción.");
        }

        return devuelve;
    }
}
/*{"jugador": {"id":1}, "equipo":{"id":2}}*/