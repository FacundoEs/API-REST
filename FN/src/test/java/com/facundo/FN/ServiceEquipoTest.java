package com.facundo.FN;

import com.facundo.FN.exceptions.ResourceNotFoundException;
import com.facundo.FN.models.EquipoModel;
import com.facundo.FN.repository.EquipoRepository;
import com.facundo.FN.services.EquipoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceEquipoTest {

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EquipoRepository equipoRepository;

    @Test
    public void testCrearEquipo() {
        EquipoModel equipo = new EquipoModel();
        equipoService.crearEquipo(equipo);
    }

    @Test
    public void testObtenerTodosEquipos() {
        equipoService.obtenerTodosEquipos();
    }

    @Test
    public void testObtenerEquipoPorId() {
        EquipoModel equipo = new EquipoModel();
        equipo.setNombre("Equipo de Prueba");
        equipo = equipoService.crearEquipo(equipo);

        Optional<EquipoModel> equipoEncontrado = equipoService.obtenerEquipoPorId(equipo.getId());

        assertTrue(((Optional<?>) equipoEncontrado).isPresent());
        assertEquals(equipo.getId(), equipoEncontrado.get().getId());
        assertEquals(equipo.getNombre(), equipoEncontrado.get().getNombre());
    }

    @Test
    public void testActualizarEquipo() throws ResourceNotFoundException {
        EquipoModel equipo = new EquipoModel();
        equipo.setNombre("Equipo de Prueba");
        equipo = equipoService.crearEquipo(equipo);

        String nuevoNombre = "Nuevo Nombre del Equipo";
        String mensajeActualizacion = equipoService.actualizarEquipo(equipo.getId(), nuevoNombre);

        assertEquals("Modificado el equipo " + equipo.getNombre() + " a " + nuevoNombre, mensajeActualizacion);

        Optional<EquipoModel> equipoActualizado = equipoService.obtenerEquipoPorId(equipo.getId());

        assertTrue(equipoActualizado.isPresent());
        assertEquals(nuevoNombre, equipoActualizado.get().getNombre());
    }

    @Test
    public void testEliminarEquipoPorId() throws ResourceNotFoundException{
        EquipoModel equipo = new EquipoModel();
        equipo.setNombre("Equipo de Prueba");
        equipo = equipoService.crearEquipo(equipo);

        String mensajeEliminacion = equipoService.eliminarEquipoPorId(equipo.getId());

        assertEquals("Eliminado el equipo: " + equipo.getNombre(), mensajeEliminacion);

        Optional<EquipoModel> equipoEliminado = equipoService.obtenerEquipoPorId(equipo.getId());

        assertFalse(equipoEliminado.isPresent());
    }
}
