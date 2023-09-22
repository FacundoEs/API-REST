package com.facundo.FN.services;
import com.facundo.FN.models.JugadorModel;
import com.facundo.FN.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JugadorService {

    private JugadorRepository jugadorRepository;
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public JugadorModel crearJugador(JugadorModel jugador) {
        return jugadorRepository.save(jugador);
    }

    public Optional<JugadorModel> obtenerJugadorPorId(Integer id) {
        return jugadorRepository.findById(id);
    }

    public List<JugadorModel> obtenerTodosJugadores() {
        return jugadorRepository.findAll();
    }

    public String actualizarJugador(Integer id, String nombreNuevo, int edadNuevo) {
        Optional<JugadorModel> optionalJugador = jugadorRepository.findById(id);
        String devuelve = "";

        if (optionalJugador.isPresent()) {
            JugadorModel jugadorModel = optionalJugador.get();

            if(nombreNuevo != jugadorModel.getNombre()){
                jugadorModel.setNombre(nombreNuevo);
                devuelve += "Modificado el jugador " + jugadorModel.getNombre() + " a " + nombreNuevo;
            }

            if(edadNuevo != jugadorModel.getEdad()){
                jugadorModel.setEdad(edadNuevo);
                devuelve += "Modificada la edad" + jugadorModel.getEdad() + " a " + edadNuevo;
            }

            jugadorRepository.save(jugadorModel);
        }

        return devuelve;
    }

    public String eliminarJugador(Integer id) {

        Optional<JugadorModel> jugador = jugadorRepository.findById(id);

        String devuelve = "";

        if (jugador.isPresent()) {
            JugadorModel equipoModel = jugador.get();
            devuelve = "Eliminado el jugador: " + equipoModel.getNombre() +  " edad: " + equipoModel.getEdad();
            jugadorRepository.deleteById(id);
        }

        return devuelve;
    }

}
