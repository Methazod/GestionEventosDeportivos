package com.gestioneventosdeportivos.services;

/**
 * Service de la reserva
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Reserva;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

public interface ReservaService {

    /**
     * Obtiene todas las reservas
     *
     * @return las reservas
     */
    public List<Reserva> getAllReservas();

    /**
     * Obtiene todas las reservas filtradas por la instalacion
     *
     * @param idInstalacion el id la instalacion a filtrar
     * @return las reservas filtradas
     */
    public List<Reserva> getAllReservasByInstalacion(@PathVariable Long idInstalacion);

    /**
     * Añade una nueva reserva
     *
     * @param newReserva la nueva reserva
     * @return la reserva nueva
     */
    public Reserva newReserva(@RequestBody Reserva newReserva);

    /**
     * Obtiene una reserva
     *
     * @param id el id de la reserva a obtener
     * @return la reserva obtenida
     */
    public Reserva getReserva(@PathVariable Long id);

    /**
     * Sustituye una reserva
     *
     * @param newReserva la nueva reserva
     * @param id el id de la reserva a sustituir
     * @return la reserva sustituida
     */
    public Reserva replaceReserva(@RequestBody Reserva newReserva, @PathVariable Long id);

    /**
     * Borra una reserva
     *
     * @param id el id de la reserva a borrar
     */
    public void deleteReserva(@PathVariable Long id);
}
