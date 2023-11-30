package top.facundo.API.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.facundo.API.exceptions.BadRequestException;
import top.facundo.API.exceptions.ResourceNotFoundException;
import top.facundo.API.models.UsuarioModel;
import top.facundo.API.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioModel crearUsuario(UsuarioModel usuario) throws BadRequestException {
        String nombreUsuario = usuario.getUsername();

        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findByUsername(nombreUsuario);

        if (usuarioExistente.isPresent()) {
            throw new BadRequestException("Ya existe un usuario con el nombre: " + nombreUsuario);
        } else {
            // Encriptar la contraseña antes de guardarla
            String contrasenaEncriptada = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(contrasenaEncriptada);
            return usuarioRepository.save(usuario);
        }
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Integer id) throws ResourceNotFoundException {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            return usuarioExistente;
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado con el ID: " + id);
        }
    }

    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioActualizado) throws ResourceNotFoundException {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            UsuarioModel usuario = usuarioExistente.get();
            usuario.setUsername(usuarioActualizado.getUsername());
            // Encriptar la contraseña solo si se proporciona una nueva contraseña
            if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
                String contrasenaEncriptada = passwordEncoder.encode(usuarioActualizado.getPassword());
                usuario.setPassword(contrasenaEncriptada);
            }
            usuario.setAppUserRole(usuarioActualizado.getAppUserRole());
            return usuarioRepository.save(usuario);
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado con el ID: " + id);
        }
    }

    public void eliminarUsuarioPorId(Integer id) throws ResourceNotFoundException {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Usuario no encontrado con el ID: " + id);
        }
    }
}
