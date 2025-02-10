package com.gestioneventosdeportivos.serviceImpl;

/**
 * Service de la reserva
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Reserva;
import com.gestioneventosdeportivos.repositories.InstalacionRepository;
import com.gestioneventosdeportivos.repositories.ReservaRepository;
import com.gestioneventosdeportivos.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    /**
     * Repo de reserva
     */
    @Autowired
    private ReservaRepository repository;

    /**
     * Repo de instalacion
     */
    @Autowired
    private InstalacionRepository instalacionRepo;

    /**
     * Obtiene todas las reservas
     *
     * @return las reservas
     */
    public List<Reserva> getAllReservas() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Obtiene todas las reservas filtradas por la instalacion
     *
     * @param idInstalacion el id la instalacion a filtrar
     * @return las reservas filtradas
     */
    public List<Reserva> getAllReservasByInstalacion(@PathVariable Long idInstalacion){
        return instalacionRepo.findById(idInstalacion).get().getReservas();
    }

    /**
     * Añade una nueva reserva
     *
     * @param newReserva la nueva reserva
     * @return la reserva nueva
     */
    public Reserva newReserva(@RequestBody Reserva newReserva) {
        return repository.save(newReserva);
    }

    /**
     * Obtiene una reserva
     *
     * @param id el id de la reserva a obtener
     * @return la reserva obtenida
     */
    public Reserva getReserva(@PathVariable Long id) {
        return repository.findById(id).get();
        // return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * Sustituye una reserva
     *
     * @param newReserva la nueva reserva
     * @param id el id de la reserva a sustituir
     * @return la reserva sustituida
     */
    public Reserva replaceReserva(@RequestBody Reserva newReserva, @PathVariable Long id) {
        return repository.findById(id)
                .map(reserva -> {
                    reserva.setFranjaHoraria(newReserva.getFranjaHoraria());
                    reserva.setFecha(newReserva.getFecha());
                    reserva.setEvento(newReserva.getEvento());
                    reserva.setInstalacion(newReserva.getInstalacion());
                    return repository.save(reserva);
                })
                .orElseGet(() -> {
                    return repository.save(newReserva);
                });
    }

    /**
     * Borra una reserva
     *
     * @param id el id de la reserva a borrar
     */
    public void deleteReserva(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
