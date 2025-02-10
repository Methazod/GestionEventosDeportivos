package com.gestioneventosdeportivos.controllers;

/**
 * Clase que implementa el controlador de una Reserva
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Reserva;
import com.gestioneventosdeportivos.serviceImpl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class ReservaController {

    /**
     * Link with reserva service
     */
    @Autowired
    private ReservaServiceImpl reservaService;

    /**
     * Get method to obtain all Reservas by his Instalacion
     *
     * @param idInstalacion identifier of the Instalacion
     * @return a list of all the Reservas that Instalacion have
     */
    @GetMapping("/reservas/{idInstalacion}")
    public List<Reserva> getAllReservasByInstalacion(@PathVariable Long idInstalacion) {
        return reservaService.getAllReservasByInstalacion(idInstalacion);
    }

    /**
     * Post method to insert a new reserva
     * @param json Contains the new reserva to be inserted
     * @return the new reserva added to the database in json format
     */
    @PostMapping("/reserva")
    public Reserva newReserva(@RequestBody Reserva json) {
        return reservaService.newReserva(json);
    }

    /**
     * Delete method to replace a specific reserva
     * @param id identifier of the reserva you want to delete
     */
    @DeleteMapping("/reserva/{id}")
    public void deleteReserva(@PathVariable Long id) { reservaService.deleteReserva(id); }
}