package top.facundo.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.JugadorModel;
import top.facundo.API.repository.JugadorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public JugadorModel crearJugador(JugadorModel jugador) throws ResourceNotFoundException {

        Optional<JugadorModel> optionalJugador = jugadorRepository.findById(jugador.getId());

        if (optionalJugador.isPresent()) {
            throw new ResourceNotFoundException("El jugador ya existe.");
        } else {
            return jugadorRepository.save(jugador);
        }
    }

    public Optional<JugadorModel> obtenerJugadorPorId(Integer id) {
        return jugadorRepository.findById(id);
    }

    public List<JugadorModel> obtenerTodosJugadores() {
        return jugadorRepository.findAll();
    }

    public String actualizarJugador(Integer id, String nombreNuevo, int edadNuevo) throws ResourceNotFoundException {
        Optional<JugadorModel> optionalJugador = jugadorRepository.findById(id);
        String devuelve = "";

        if (optionalJugador.isPresent()) {
            JugadorModel jugadorModel = optionalJugador.get();

            if(!Objects.equals(nombreNuevo, jugadorModel.getNombre())){
                jugadorModel.setNombre(nombreNuevo);
                devuelve += "Modificado el jugador " + jugadorModel.getNombre() + " a " + nombreNuevo;
            }

            if(edadNuevo != jugadorModel.getEdad()){
                jugadorModel.setEdad(edadNuevo);
                devuelve += "Modificada la edad" + jugadorModel.getEdad() + " a " + edadNuevo;
            }

            jugadorRepository.save(jugadorModel);
        }else {
            throw new ResourceNotFoundException("No existe el jugador");
        }

        return devuelve;
    }

    public String eliminarJugador(Integer id) throws ResourceNotFoundException {

        Optional<JugadorModel> jugador = jugadorRepository.findById(id);

        String devuelve = "";

        if (jugador.isPresent()) {
            JugadorModel equipoModel = jugador.get();
            devuelve = "Eliminado el jugador: " + equipoModel.getNombre() +  " edad: " + equipoModel.getEdad();
            jugadorRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el jugador.");
        }

        return devuelve;
    }

}
