package com.gestioneventosdeportivos.services;

/**
 * Service del usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface UsuarioService {

    /**
     * Devuelve todos los usuarios
     *
     * @return los usuarios
     */
    public List<Usuario> getAllUsuarios();

    /**
     * Añade un usuario
     *
     * @param newUsuario el nuevo usuario
     * @return el nuevo usuario
     */
    public Usuario newUsuario(@RequestBody Usuario newUsuario);

    /**
     * Obtiene un usuario
     *
     * @param id el id del usuario a obtener
     * @return el usuario obtenido
     */
    public Usuario getUsuario(@PathVariable Long id);

    /**
     * Sustituye un usuario
     *
     * @param newUsuario el nuevo usuario
     * @param id el id del usuario a sustituir
     * @return el usuario sustituido
     */
    public Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id);

    /**
     * Borra un usuario
     *
     * @param id el id del usuario a borrar
     */
    public void deleteUsuario(@PathVariable Long id);
}
