package com.facundo.FN.services;

import com.facundo.FN.exceptions.ResourceNotFoundException;
import com.facundo.FN.models.EquipoModel;
import com.facundo.FN.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    private EquipoRepository equipoRepository;
    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public EquipoModel crearEquipo(EquipoModel equipo) {
        return equipoRepository.save(equipo);
    }

    public Optional<EquipoModel> obtenerEquipoPorId(Integer id) {
        return equipoRepository.findById(id);
    }

    public List<EquipoModel> obtenerTodosEquipos() {
        return equipoRepository.findAll();
    }

    public String actualizarEquipo(Integer id, String nombreNuevo) throws ResourceNotFoundException {

        Optional<EquipoModel> optionalEquipo = equipoRepository.findById(id);
        String devuelve = "";

        if (optionalEquipo.isPresent()) {
            EquipoModel equipoModel = optionalEquipo.get();
            devuelve = "Modificado el equipo " + equipoModel.getNombre() + " a " + nombreNuevo;
            equipoModel.setNombre(nombreNuevo);
            equipoRepository.save(equipoModel);
        }else {
            throw new ResourceNotFoundException("No existe el equipo");
        }

        return devuelve;
    }

    public String eliminarEquipoPorId(Integer id) throws ResourceNotFoundException{

        Optional<EquipoModel> equipo = equipoRepository.findById(id);

        String devuelve = "";

        if (equipo.isPresent()) {
            EquipoModel equipoModel = equipo.get();
            devuelve = "Eliminado el equipo: " + equipoModel.getNombre();
            equipoRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No existe el equipo.");
        }

        return devuelve;
    }

}