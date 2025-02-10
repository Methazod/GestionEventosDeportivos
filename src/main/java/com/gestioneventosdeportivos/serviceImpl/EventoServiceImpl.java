package com.gestioneventosdeportivos.serviceImpl;

/**
 * Implementacion del service del evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Evento;
import com.gestioneventosdeportivos.repositories.EventoRepository;
import com.gestioneventosdeportivos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    /**
     * Repositorio del evento
     */
    @Autowired // Inyeccion de depencia del repositorio
    private EventoRepository repository;

    /**
     * Devuelve todos los eventos
     *
     * @return todos los eventos
     */
    public List<Evento> getAllEventos() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade un nuevo evento
     *
     * @param newEvento el nuevo evento
     * @return el nuevo evento
     */
    public Evento newEvento(@RequestBody Evento newEvento) {
        return repository.save(newEvento);
    }

    /**
     * Obtiene un evento
     *
     * @param id el id del evento
     * @return el evento
     */
    public Evento getEvento(@PathVariable Long id) {
        return repository.findById(id).get();
        // return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * Sustituye un evento
     *
     * @param newEvento el nuevo evento
     * @param id el id del evento a sustituir
     * @return el evento sustituido
     */
    public Evento replaceEvento(@RequestBody Evento newEvento, @PathVariable Long id) {
        return repository.findById(id)
                .map(evento -> {
                    evento.setNombre(newEvento.getNombre());
                    evento.setDescripcion(newEvento.getDescripcion());
                    evento.setFecha(newEvento.getFecha());
                    evento.setHora(newEvento.getHora());
                    evento.setDuracion(newEvento.getDuracion());
                    evento.setReserva(newEvento.getReserva());
                    evento.setUsuarios(newEvento.getUsuarios());
                    return repository.save(evento);
                })
                .orElseGet(() -> {
                    return repository.save(newEvento);
                });
    }

    /**
     * Borrar un evento
     *
     * @param id del evento a borrar
     */
    public void deleteEvento(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     * Devuelve todos los eventos filtrados por una fecha
     *
     * @param fecha la fecha a filtrar
     * @return los eventos filtrados
     */
    public List<Evento> getAllEventosByFecha(@RequestBody Date fecha) {
        List<Evento> eventos = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formatter.format(fecha);
        for (Evento evento : getAllEventos()) {
            String fechaComparacion = formatter.format(evento.getFecha());
            if (fechaString.equals(fechaComparacion)) eventos.add(evento);
        }
        return eventos;
    }
}
