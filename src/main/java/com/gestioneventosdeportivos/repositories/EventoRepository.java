package com.gestioneventosdeportivos.repositories;

/**
 * Repositorio del evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}