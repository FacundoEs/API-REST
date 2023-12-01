package top.facundo.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.models.DatosDelClubModel;
import top.facundo.API.repository.DatosDelClubRepository;

import java.util.List;

@Service
public class DatosDelClubService {

    private final DatosDelClubRepository datosDelClubRepository;

    @Autowired
    public DatosDelClubService(DatosDelClubRepository datosDelClubRepository) {
        this.datosDelClubRepository = datosDelClubRepository;
    }

    public DatosDelClubModel crearDatosDelClub(DatosDelClubModel datosDelClub) {
        // Verificar si ya existe un registro
        if (datosDelClubRepository.count() > 0) {
            // Si ya existe un registro, no permitir crear uno nuevo
            throw new IllegalStateException("Ya existe un registro de Datos del Club.");
        } else {
            // Si no existe ningún registro, guardar el nuevo registro
            return datosDelClubRepository.save(datosDelClub);
        }
    }

    public List<DatosDelClubModel> obtenerTodosDatosDelClub() {
        return datosDelClubRepository.findAll();
    }

    public DatosDelClubModel actualizarDatosDelClub(Integer id, DatosDelClubModel datosActualizados) {
        DatosDelClubModel datosDelClubExistente = datosDelClubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró Datos del Club con el ID: " + id));

        datosDelClubExistente.setNombreDelClub(datosActualizados.getNombreDelClub());
        datosDelClubExistente.setDescripcionDelClub(datosActualizados.getDescripcionDelClub());

        return datosDelClubRepository.save(datosDelClubExistente);
    }
}

