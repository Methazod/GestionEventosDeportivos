package com.gestioneventosdeportivos.services;

/**
 * Service del evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Evento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Date;
import java.util.List;

public interface EventoService {

    /**
     * Devuelve todos los eventos
     *
     * @return todos los eventos
     */
    public List<Evento> getAllEventos();

    /**
     * Añade un nuevo evento
     *
     * @param newEvento el nuevo evento
     * @return el nuevo evento
     */
    public Evento newEvento(@RequestBody Evento newEvento);

    /**
     * Obtiene un evento
     *
     * @param id el id del evento
     * @return el evento
     */
    public Evento getEvento(@PathVariable Long id);

    /**
     * Sustituye un evento
     *
     * @param newEvento el nuevo evento
     * @param id el id del evento a sustituir
     * @return el evento sustituido
     */
    public Evento replaceEvento(@RequestBody Evento newEvento, @PathVariable Long id);

    /**
     * Borrar un evento
     *
     * @param id del evento a borrar
     */
    public void deleteEvento(@PathVariable Long id);

    /**
     * Devuelve todos los eventos filtrados por una fecha
     *
     * @param fecha la fecha a filtrar
     * @return los eventos filtrados
     */
    public List<Evento> getAllEventosByFecha(@RequestBody Date fecha);
}
