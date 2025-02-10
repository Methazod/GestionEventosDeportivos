package com.gestioneventosdeportivos.controllers;

/**
 * Clase que implementa el controlador de un Evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Evento;
import com.gestioneventosdeportivos.serviceImpl.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@RestController
class EventoController {

    /**
     * Link with evento service
     */
    @Autowired
    private EventoServiceImpl eventoService;

    /**
     * Get method to obtain all eventos
     * @return a list of all eventos stored in the database
     */
    @GetMapping("/eventos")
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    /**
     * Post method to insert a new evento
     * @param json Contains the new evento to be inserted
     * @return the new evento added to the database in json format
     */
    @PostMapping("/evento")
    public Evento newEvento(@RequestBody Evento json) {
        return eventoService.newEvento(json);
    }

    /**
     * Put method to replace a specific evento
     * @param newEvento new data to insert
     * @param id identifier of the evento you want to replace
     * @return the evento replaced in json format
     */
    @PutMapping("/evento/{id}")
    public Evento replaceEvento(@RequestBody Evento newEvento, @PathVariable Long id) {
        return eventoService.replaceEvento(newEvento, id);
    }

    /**
     * Delete method to replace a specific evento
     * @param id identifier of the evento you want to delete
     */
    @DeleteMapping("/evento/{id}")
    public void deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
    }

    /**
     * Post method to obtain all eventos by fecha
     * @return a list of all eventos stored in the database
     */
    @PostMapping("/eventosFecha")
    public List<Evento> getAllEventosByFecha(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
        return eventoService.getAllEventosByFecha(fecha);
    }
}