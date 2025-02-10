package com.gestioneventosdeportivos.serviceImpl;

/**
 * Service del usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Usuario;
import com.gestioneventosdeportivos.repositories.UsuarioRepository;
import com.gestioneventosdeportivos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * Repo del usuario
     */
    @Autowired
    private UsuarioRepository repository;

    /**
     * Devuelve todos los usuarios
     *
     * @return los usuarios
     */
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade un usuario
     *
     * @param newUsuario el nuevo usuario
     * @return el nuevo usuario
     */
    public Usuario newUsuario(@RequestBody Usuario newUsuario) {
        return repository.save(newUsuario);
    }

    /**
     * Obtiene un usuario
     *
     * @param id el id del usuario a obtener
     * @return el usuario obtenido
     */
    public Usuario getUsuario(@PathVariable Long id) {
        return repository.findById(id).get();
        // return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * Sustituye un usuario
     *
     * @param newUsuario el nuevo usuario
     * @param id el id del usuario a sustituir
     * @return el usuario sustituido
     */
    public Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setNombre(newUsuario.getNombre());
                    user.setEmail(newUsuario.getEmail());
                    user.setEventos(newUsuario.getEventos());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    return repository.save(newUsuario);
                });
    }

    /**
     * Borra un usuario
     *
     * @param id el id del usuario a borrar
     */
    public void deleteUsuario(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
