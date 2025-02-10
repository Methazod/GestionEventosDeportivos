package com.gestioneventosdeportivos.controllers;

/**
 * Clase que implementa el controlador de una Instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Instalacion;
import com.gestioneventosdeportivos.serviceImpl.InstalacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
class InstalacionController {

    /**
     * Link with instalacion service
     */
    @Autowired
    private InstalacionServiceImpl instalacionService;

    /**
     * Get method to obtain all instalaciones
     * @return a list of all instalaciones stored in the database
     */
    @GetMapping("/instalaciones")
    public List<Instalacion> getAllInstalaciones() {
        return instalacionService.getAllInstalaciones();
    }

    /**
     * Post method to insert a new instalacion
     * @param json Contains the new instalacion to be inserted
     * @return the new instalacion added to the database in json format
     */
    @PostMapping("/instalacion")
    public Instalacion newInstalacion(@RequestBody Instalacion json) {
        return instalacionService.newInstalacion(json);
    }

    /**
     * Delete method to replace a specific instalacion
     * @param id identifier of the instalacion you want to delete
     */
    @DeleteMapping("/instalacion/{id}")
    public void deleteInstalacion(@PathVariable Long id) {
        instalacionService.deleteInstalacion(id);
    }

    /**
     * Post method to obtain all instalaciones by ubicacion
     *
     * @param ubicacion ubicacion to filter
     * @return a list of all instalaciones filtered
     */
    @PostMapping("/instalacionesUbicacion")
    public List<Instalacion> getAllInstalacionesByUbicacion(@RequestBody String ubicacion){
        return instalacionService.getAllInstalacionesByUbicacion(ubicacion);
    }

    /**
     * Post method to obtain all instalaciones by fecha
     *
     * @param fecha fecha to filter
     * @return a list of all instalaciones filtered
     */
    @PostMapping("/instalacionesFecha")
    public List<Instalacion> getInstalacionesByFecha(@RequestBody Date fecha) {
        return instalacionService.getInstalacionesByFecha(fecha);
    }
}