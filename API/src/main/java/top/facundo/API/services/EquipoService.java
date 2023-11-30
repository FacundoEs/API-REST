package top.facundo.API.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.EquipoModel;
import top.facundo.API.repository.EquipoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;
    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public EquipoModel crearEquipo(EquipoModel equipo) throws BadRequestException {
        String nombreEquipo = equipo.getNombre();

        Optional<EquipoModel> equipoExistente = equipoRepository.findByNombre(nombreEquipo);

        if (equipoExistente.isPresent()) {
            throw new BadRequestException("Ya existe un equipo con el nombre: " + nombreEquipo);
        } else {
            return equipoRepository.save(equipo);
        }
    }

    public Optional<EquipoModel> obtenerEquipoPorId(Integer id) throws ResourceNotFoundException {
        Optional<EquipoModel> equipoExistente = equipoRepository.findById(id);

        if (equipoExistente.isPresent()) {
            return equipoExistente;
        } else {
            throw new ResourceNotFoundException("Equipo no encontrado con el ID: " + id);
        }
    }

    public List<EquipoModel> obtenerTodosEquipos() {
        return equipoRepository.findAll();
    }

    public EquipoModel actualizarEquipo(Integer id, EquipoModel equipoActualizado) throws ResourceNotFoundException {
        Optional<EquipoModel> equipoExistente = equipoRepository.findById(id);

        if (equipoExistente.isPresent()) {
            EquipoModel equipo = equipoExistente.get();
            equipo.setNombre(equipoActualizado.getNombre());
            equipo.setDescripcion(equipoActualizado.getDescripcion());
            return equipoRepository.save(equipo);
        } else {
            throw new ResourceNotFoundException("Equipo no encontrado con el ID: " + id);
        }
    }
    public void eliminarEquipoPorId(Integer id) throws ResourceNotFoundException {
        Optional<EquipoModel> equipoExistente = equipoRepository.findById(id);

        if (equipoExistente.isPresent()) {
            equipoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Equipo no encontrado con el ID: " + id);
        }
    }
}
