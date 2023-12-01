package top.facundo.API;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.EquipoModel;
import top.facundo.API.repository.EquipoRepository;
import top.facundo.API.services.EquipoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @InjectMocks
    private EquipoService equipoService;

    @Before
    public void setUp() {
        // Configuración inicial, si es necesaria
    }

    @Test
    public void testCrearEquipo() throws BadRequestException {
        EquipoModel equipo = new EquipoModel();
        equipo.setNombre("Equipo de Prueba");
        equipo.setDescripcion("Descripción de prueba");

        when(equipoRepository.findByNombre(any())).thenReturn(Optional.empty());
        when(equipoRepository.save(any())).thenReturn(equipo);

        EquipoModel result = equipoService.crearEquipo(equipo);

        assertEquals("Equipo de Prueba", result.getNombre());
        assertEquals("Descripción de prueba", result.getDescripcion());

        verify(equipoRepository, times(1)).findByNombre(any());
        verify(equipoRepository, times(1)).save(any());
    }

    @Test
    public void testObtenerTodosEquipos() {
        List<EquipoModel> equipos = new ArrayList<>();
        equipos.add(new EquipoModel());
        equipos.add(new EquipoModel());

        when(equipoRepository.findAll()).thenReturn(equipos);

        List<EquipoModel> result = equipoService.obtenerTodosEquipos();

        assertEquals(2, result.size());

        verify(equipoRepository, times(1)).findAll();
    }

    @Test
    public void testObtenerEquipoPorId() throws ResourceNotFoundException {
        int equipoId = 1;
        EquipoModel equipo = new EquipoModel();
        equipo.setId(equipoId);
        equipo.setNombre("Equipo de Prueba");
        equipo.setDescripcion("Descripción de prueba");

        when(equipoRepository.findById(equipoId)).thenReturn(Optional.of(equipo));

        Optional<EquipoModel> result = equipoService.obtenerEquipoPorId(equipoId);

        assertEquals("Equipo de Prueba", result.get().getNombre());
        assertEquals("Descripción de prueba", result.get().getDescripcion());

        verify(equipoRepository, times(1)).findById(equipoId);
    }

    @Test
    public void testActualizarEquipo() throws ResourceNotFoundException {
        int equipoId = 1;
        EquipoModel equipo = new EquipoModel();
        equipo.setId(1);
        equipo.setNombre("Equipo Original");
        equipo.setDescripcion("Descripción Original");

        when(equipoRepository.findById(equipoId)).thenReturn(Optional.of(equipo));
        when(equipoRepository.save(any())).thenReturn(equipo);

        EquipoModel equipoActualizado = new EquipoModel();
        equipoActualizado.setId(equipoId);
        equipoActualizado.setNombre("Equipo Actualizado");
        equipoActualizado.setDescripcion("Descripción Actualizada");

        EquipoModel result = equipoService.actualizarEquipo(equipoId, equipoActualizado);

        assertEquals("Equipo Actualizado", result.getNombre());
        assertEquals("Descripción Actualizada", result.getDescripcion());

        verify(equipoRepository, times(1)).findById(equipoId);
        verify(equipoRepository, times(1)).save(any());
    }

    @Test
    public void testEliminarEquipoPorId() throws ResourceNotFoundException {
        int equipoId = 1;

        // Simular la existencia del equipo con el ID 1 en el repositorio
        //when(equipoRepository.findById(equipoId)).thenReturn(Optional.of(new EquipoModel()));
        //Este test es para ver que ocurre cuando intentamos eliminar un equipo que no existe

        equipoService.eliminarEquipoPorId(equipoId);

        verify(equipoRepository, times(1)).deleteById(equipoId);
    }
}
