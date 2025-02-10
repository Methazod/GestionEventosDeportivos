package com.gestioneventosdeportivos.serviceImpl;

/**
 * Implementacion del Service de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Instalacion;
import com.gestioneventosdeportivos.models.Reserva;
import com.gestioneventosdeportivos.repositories.InstalacionRepository;
import com.gestioneventosdeportivos.repositories.ReservaRepository;
import com.gestioneventosdeportivos.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstalacionServiceImpl implements InstalacionService {

    /**
     * Repo de instalacion
     */
    @Autowired
    private InstalacionRepository repository;

    /**
     * Repo de reserva
     */
    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Devuelve todas las instalaciones
     *
     * @return las instalaciones
     */
    public List<Instalacion> getAllInstalaciones() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    /**
     * Añade una nueva instalacion
     *
     * @param newInstalacion la nueva instalacion
     * @return la nueva instalacion
     */
    public Instalacion newInstalacion(@RequestBody Instalacion newInstalacion) {
        return repository.save(newInstalacion);
    }

    /**
     * Obtiene una instalacion
     *
     * @param id el id de la instalacion a buscar
     * @return la instalacion
     */
    public Instalacion getInstalacion(@PathVariable Long id) {
        return repository.findById(id).get();
        // return repository.findById(id)
        //      .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /**
     * Sustituye una instalacion
     *
     * @param newInstalacion la nueva instalacion
     * @param id el id de la instalacion a sustituir
     * @return la instalacion sustituida
     */
    public Instalacion replaceInstalacion(@RequestBody Instalacion newInstalacion, @PathVariable Long id) {
        return repository.findById(id)
                .map(instalacion -> {
                    instalacion.setNombre(newInstalacion.getNombre());
                    instalacion.setTipoInstalacion(newInstalacion.getTipoInstalacion());
                    instalacion.setUbicacion(newInstalacion.getUbicacion());
                    instalacion.setReservas(newInstalacion.getReservas());
                    return repository.save(instalacion);
                })
                .orElseGet(() -> {
                    return repository.save(newInstalacion);
                });
    }

    /**
     * Borra una instalacion
     *
     * @param id el id de la instalacion a borrar
     */
    public void deleteInstalacion(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     * Devuelve todas las instalaciones filtradas por una ubicacion
     *
     * @param ubicacion la ubicacion para filtrar
     * @return las instalaciones filtradas
     */
    public List<Instalacion> getAllInstalacionesByUbicacion(@RequestBody String ubicacion) {
        ubicacion = ubicacion.replace("\"", "");

        List<Instalacion> instalaciones = new ArrayList<>();
        for (Instalacion instalacion : getAllInstalaciones()) {
            if (instalacion.getUbicacion().equalsIgnoreCase(ubicacion)) instalaciones.add(instalacion);
        }
        return instalaciones;
    }

    /**
     * Devuelve todas las instalaciones filtradas por una fecha
     *
     * @param fecha la fecha para filtrar
     * @return las instalaciones filtradas
     */
    public List<Instalacion> getInstalacionesByFecha(@RequestBody Date fecha) {
        List<Instalacion> instalaciones = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formatter.format(fecha);
        for (Reserva reserva : reservaRepository.findAll()) {
            String fechaComparacion = formatter.format(reserva.getFecha());
            if(fechaComparacion.equals(fechaString)) instalaciones.add(reserva.getInstalacion());
        }
        return instalaciones;
    }
}
