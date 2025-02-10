package com.gestioneventosdeportivos.models;

/**
 * Modelo del Evento
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "evento")
public class Evento {

    /**
     * Id del Evento
     */
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre del Evento
     */
    private String nombre;

    /**
     * Descripcion del Evento
     */
    private String descripcion;

    /**
     * Fecha del Evento
     */
    private Date fecha;

    /**
     * Hora del Evento
     */
    private Time hora;

    /**
     * Duracion del Evento
     */
    private int duracion;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Lista de usuarios del evento
     */
    @JsonIgnoreProperties("eventos")
    @ManyToMany(mappedBy = "eventos") // nombre de la lista de la clase Usuario
    private List<Usuario> usuarios = new ArrayList<>();

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Reserva del evento
     */
    @JsonIgnoreProperties("evento")
    @OneToOne(mappedBy = "evento", cascade = CascadeType.ALL)
    private Reserva reserva;

    /**
     * Construye una evento
     */
    public Evento() {}

    /**
     * Construye un evento
     *
     * @param nombre nombre del evento
     * @param descripcion descripcion del evento
     * @param fecha fecha del evento
     * @param hora hora del evento
     * @param duracion duracion del evento
     */
    public Evento(String nombre, String descripcion, Date fecha, Time hora, int duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
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
     * Getter del nombre
     *
     * @return el nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de la descripcion
     *
     * @return la descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }


    /**
     * Getter de la fecha
     *
     * @return la fecha
     */
    public Date getFecha() { return fecha; }

    /**
     * Getter de la hora
     *
     * @return la hora
     */
    public Time getHora() { return hora; }

    /**
     * Getter de la duracion
     *
     * @return la duracion
     */
    public int getDuracion() { return duracion; }

    /**
     * Getter de los usuarios
     *
     * @return los usuarios
     */
    public List<Usuario> getUsuarios() { return usuarios; }

    /**
     * Getter de la reservas
     *
     * @return la reserva
     */
    public Reserva getReserva() { return reserva; }

    /**
     * Setter del id
     *
     * @param id el id a guardar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter del nombre
     *
     * @param nombre el nombre a guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter de la descripcion
     *
     * @param descripcion la descripcion a guardar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Setter de la fecha
     *
     * @param fecha la fecha a guardar
     */
    public void setFecha(Date fecha) { this.fecha = fecha; }

    /**
     * Setter de la hora
     *
     * @param hora la hora a guardar
     */
    public void setHora(Time hora) { this.hora = hora; }

    /**
     * Setter de la duracion
     *
     * @param duracion la duracion a guardar
     */
    public void setDuracion(int duracion) { this.duracion = duracion; }

    /**
     * Setter de los usuarios
     *
     * @param usuarios los usuarios a guardar
     */
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }

    /**
     * Setter de la reserva
     *
     * @param reserva la reserva a guardar
     */
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    /**
     * Metodo que compara un evento con este
     *
     * @param o el evento a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Evento))
            return false;
        Evento evento = (Evento) o;
        return Objects.equals(this.id, evento.id)
                && Objects.equals(this.nombre, evento.nombre)
                && Objects.equals(this.descripcion, evento.descripcion)
                && Objects.equals(this.fecha, evento.fecha)
                && Objects.equals(this.hora, evento.hora)
                && Objects.equals(this.duracion, evento.duracion)
                && Objects.equals(this.usuarios, evento.usuarios)
                && Objects.equals(this.reserva, evento.reserva);
    }

    /**
     * Metodo que devuelve el hash del evento
     *
     * @return el hash del evento
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.descripcion, this.fecha,
                this.hora, this.duracion, this.usuarios, this.reserva);
    }

    /**
     * Metodo que cambia la salida estandar al imprimir el evento
     *
     * @return el evento imprimido
     */
    @Override
    public String toString() {
        return "Evento{" + "id=" + this.id + ", nombre='" + this.nombre + '\''
                + ", descripcion='" + this.descripcion + '\''
                + ", fecha='" + this.fecha + '\''
                + ", hora='" + this.hora + '\''
                + ", duracion='" + this.duracion + '\''
                + '}';
    }
}
