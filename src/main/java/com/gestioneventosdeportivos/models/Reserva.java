package com.gestioneventosdeportivos.models;

/**
 * Modelo de la Reserva
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table(name = "reserva")
public class Reserva {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Fecha de la reserva
     */
    private Date fecha;

    /**
     * Franja horaria de la Reserva
     */
    private String franja_horaria;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Evento de la reserva
     */
    @JsonIgnoreProperties("reserva")
    @OneToOne
    @JoinColumn(name = "evento_id", updatable = true, nullable = true)
    private Evento evento;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Instalacion de la reserva
     */
    @JsonIgnoreProperties("reservas")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "instalacion_id") // id de la instalacion de la tabla reserva
    private Instalacion instalacion;

    /**
     * Construye la reserva
     */
    public Reserva() {}

    /**
     * Construye la reserva
     *
     * @param fecha fecha de la reserva
     * @param franja_horaria franja horaria de la reserva
     */
    public Reserva(Date fecha, String franja_horaria) {
        this.fecha = fecha;
        this.franja_horaria = franja_horaria;
    }

    /**
     * Getter del id
     *
     * @return el id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter de la fecha
     *
     * @return la fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Getter de la franja horaria
     *
     * @return la franja horaria
     */
    public String getFranjaHoraria() {
        return this.franja_horaria;
    }

    /**
     * Getter del evento
     *
     * @return el evento
     */
    public Evento getEvento() { return evento; }

    /**
     * Getter de la instalacion
     *
     * @return la instalacion
     */
    public Instalacion getInstalacion() { return instalacion; }

    /**
     * Setter del id
     *
     * @param id el nuevo id
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Setter de la fecha
     *
     * @param fecha la nueva fecha
     */
    public void setFecha(Date fecha) { this.fecha = fecha; }

    /**
     * Setter de la franja horaria
     *
     * @param franja_horaria la nueva franja horaria
     */
    public void setFranjaHoraria(String franja_horaria) { this.franja_horaria = franja_horaria; }

    /**
     * Setter del evento
     *
     * @param evento el nuevo evento
     */
    public void setEvento(Evento evento) { this.evento = evento; }

    /**
     * Setter de la instalacion
     *
     * @param instalacion la nueva instalacion
     */
    public void setInstalacion(Instalacion instalacion) { this.instalacion = instalacion; }

    /**
     * Compara una reserva con esta reserva
     *
     * @param o la reserva a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Reserva))
            return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(this.id, reserva.id)
            && Objects.equals(this.fecha, reserva.fecha)
            && Objects.equals(this.franja_horaria, reserva.franja_horaria)
            && Objects.equals(this.evento, reserva.evento)
            && Objects.equals(this.instalacion, reserva.instalacion);
    }

    /**
     * Metodo que devuelve el hash de la reserva
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.fecha,
                this.franja_horaria, this.evento, this.instalacion);
    }

    /**
     * Metodo que cambia la impresion de la reserva
     *
     * @return la impresion de la reserva
     */
    @Override
    public String toString() {
        return "Reserva{" + "id=" + this.id + ", fecha='" + this.fecha + '\''
                + ", franjaHoraria='" + this.franja_horaria + '\'' + '}';
    }
}