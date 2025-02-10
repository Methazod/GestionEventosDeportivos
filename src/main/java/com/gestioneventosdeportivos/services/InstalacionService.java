package com.gestioneventosdeportivos.services;

/**
 * Service de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Instalacion;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Date;
import java.util.List;

public interface InstalacionService {

    /**
     * Devuelve todas las instalaciones
     *
     * @return las instalaciones
     */
    public List<Instalacion> getAllInstalaciones();

    /**
     * Devuelve todas las instalaciones filtradas por una ubicacion
     *
     * @param ubicacion la ubicacion para filtrar
     * @return las instalaciones filtradas
     */
    public List<Instalacion> getAllInstalacionesByUbicacion(@RequestBody String ubicacion);

    /**
     * Devuelve todas las instalaciones filtradas por una fecha
     *
     * @param fecha la fecha para filtrar
     * @return las instalaciones filtradas
     */
    public List<Instalacion> getInstalacionesByFecha(@RequestBody Date fecha);

    /**
     * Añade una nueva instalacion
     *
     * @param newInstalacion la nueva instalacion
     * @return la nueva instalacion
     */
    public Instalacion newInstalacion(@RequestBody Instalacion newInstalacion);

    /**
     * Obtiene una instalacion
     *
     * @param id el id de la instalacion a buscar
     * @return la instalacion
     */
    public Instalacion getInstalacion(@PathVariable Long id);

    /**
     * Sustituye una instalacion
     *
     * @param newInstalacion la nueva instalacion
     * @param id el id de la instalacion a sustituir
     * @return la instalacion sustituida
     */
    public Instalacion replaceInstalacion(@RequestBody Instalacion newInstalacion, @PathVariable Long id);

    /**
     * Borra una instalacion
     *
     * @param id el id de la instalacion a borrar
     */
    public void deleteInstalacion(@PathVariable Long id);
}
