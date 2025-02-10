package com.gestioneventosdeportivos.repositories;

/**
 * Repositorio de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.gestioneventosdeportivos.models.Instalacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstalacionRepository extends JpaRepository<Instalacion, Long> {

}