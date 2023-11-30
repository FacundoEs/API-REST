package top.facundo.API.services;

import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.repository.InscripcionRepository;
import top.facundo.API.models.InscripcionModel;
import top.facundo.API.models.EquipoModel;
import top.facundo.API.models.JugadorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    public InscripcionModel guardarInscripcion(InscripcionModel inscripcion) throws BadRequestException {
        JugadorModel jugador = inscripcion.getJugador();
        EquipoModel equipo = inscripcion.getEquipo();

        List<InscripcionModel> inscripcionesExistentes = inscripcionRepository.findByJugadorAndEquipo(jugador, equipo);

        if (!inscripcionesExistentes.isEmpty()) {
            throw new BadRequestException("El jugador ya está inscrito en este equipo.");
        } else {
            return inscripcionRepository.save(inscripcion);
        }
    }

    public Optional<InscripcionModel> obtenerInscripcionPorId(Integer id) throws ResourceNotFoundException {
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isPresent()) {
            return inscripcion;
        } else {
            throw new ResourceNotFoundException("Inscripción no encontrada.");
        }
    }

    public List<InscripcionModel> obtenerTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public void eliminarInscripcionPorId(Integer id) throws ResourceNotFoundException {
        Optional<InscripcionModel> inscripcion = inscripcionRepository.findById(id);

        if (inscripcion.isPresent()) {
            inscripcionRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Inscripción no encontrada");
        }
    }
}
