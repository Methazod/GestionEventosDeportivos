package com.gestioneventosdeportivos.controllers;

/**
 * Clase que implementa el controlador de un Usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Usuario;
import com.gestioneventosdeportivos.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class UsuarioController {

    /**
     * Link with usuario service
     */
    @Autowired
    private UsuarioServiceImpl usuarioService;

    /**
     * Get method to obtain all usuarios
     * @return a list of all usuarios stored in the database
     */
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     * Post method to insert a new usuario
     * @param json Contains the new usuario to be inserted
     * @return the new usuario added to the database in json format
     */
    @PostMapping("/usuario")
    public Usuario newUsuario(@RequestBody Usuario json) {
        return usuarioService.newUsuario(json);
    }

    /**
     * Put method to replace a specific usuario
     * @param newUser new data to insert
     * @param id identifier of the usuario you want to replace
     * @return the usuario replaced in json format
     */
    @PutMapping("/usuario/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario newUser, @PathVariable Long id) {
        return usuarioService.replaceUsuario(newUser, id);
    }

    /**
     * Delete method to replace a specific usuario
     * @param id identifier of the usuario you want to delete
     */
    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}