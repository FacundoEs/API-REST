package top.facundo.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.JugadorModel;
import top.facundo.API.repository.JugadorRepository;

import java.util.List;
import java.util.Optional;
@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public JugadorModel crearJugador(JugadorModel jugador) {
        return jugadorRepository.save(jugador);
    }

    public Optional<JugadorModel> obtenerJugadorPorId(Integer id) throws ResourceNotFoundException{
        Optional<JugadorModel> jugadorExistente = jugadorRepository.findById(id);

        if (jugadorExistente.isPresent()) {
            return jugadorExistente;
        }else {
            throw new ResourceNotFoundException("Jugador no encontrado con el ID: " + id);
        }
    }

    public List<JugadorModel> obtenerTodosLosJugadores() {
        return jugadorRepository.findAll();
    }

    public JugadorModel actualizarJugador(Integer id, JugadorModel jugadorActualizado) throws ResourceNotFoundException {
        Optional<JugadorModel> jugadorExistente = jugadorRepository.findById(id);

        if (jugadorExistente.isPresent()) {
            JugadorModel jugador = jugadorExistente.get();
            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setEdad(jugadorActualizado.getEdad());
            return jugadorRepository.save(jugador);
        } else {
            throw new ResourceNotFoundException("Jugador no encontrado con el ID: " + id);
        }

    }
    public void eliminarJugadorPorId(Integer id) throws ResourceNotFoundException {
        Optional<JugadorModel> jugadorExistente = jugadorRepository.findById(id);

        if (jugadorExistente.isPresent()) {
            jugadorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Jugador no encontrado con el ID: " + id);
        }
    }
}
