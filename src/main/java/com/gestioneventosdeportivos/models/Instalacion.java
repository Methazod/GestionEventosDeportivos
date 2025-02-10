package com.gestioneventosdeportivos.models;

/**
 * Modelo de la instalacion
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "instalacion")
public class Instalacion {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre de la instalacion
     */
    private String nombre;

    /**
     * Tipo del instalacion
     */
    private String tipo_instalacion;

    /**
     * Ubicacion del instalacion
     */
    private String ubicacion;

    /**
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     *
     * Lista con las reservas de las instalaciones
     */
    @JsonIgnoreProperties("instalacion")
    @OneToMany(mappedBy = "instalacion", cascade = CascadeType.PERSIST, orphanRemoval = true) // Mapped by guarda el nombre del atributo de la clase
    private List<Reserva> reservas = new ArrayList<>();

    /**
     * Construye una instalacion
     */
    public Instalacion() {}

    /**
     * Construye una instalacion
     *
     * @param nombre nombre de la instalacion
     * @param tipo_instalacion tipo de la instalacion
     * @param ubicacion ubicacion de la instalacion
     */
    public Instalacion(String nombre, String tipo_instalacion, String ubicacion) {
        this.nombre = nombre;
        this.tipo_instalacion = tipo_instalacion;
        this.ubicacion = ubicacion;
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
     * Getter del tipo
     *
     * @return el tipo
     */
    public String getTipoInstalacion() {
        return this.tipo_instalacion;
    }

    /**
     * Getter de la ubicacion
     *
     * @return la ubicacion
     */
    public String getUbicacion() { return this.ubicacion; }

    /**
     * Getter de las reservas
     *
     * @return las reservas
     */
    public List<Reserva> getReservas() { return reservas; }

    /**
     * Setter del id
     *
     * @param id el nuevo id
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Setter del nombre
     *
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Setter del tipo
     *
     * @param tipo_instalacion el nuevo tipo
     */
    public void setTipoInstalacion(String tipo_instalacion) { this.tipo_instalacion = tipo_instalacion; }

    /**
     * Setter de la ubicacion
     *
     * @param ubicacion la nueva ubicacion
     */
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    /**
     * Setter de las reservas
     *
     * @param reservas las nuevas reservas
     */
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    /**
     * Metodo que compara una Instalacion con esta Instalacion
     *
     * @param o la instalacion a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Instalacion))
            return false;
        Instalacion instalacion = (Instalacion) o;
        return Objects.equals(this.id, instalacion.id)
                && Objects.equals(this.nombre, instalacion.nombre)
                && Objects.equals(this.tipo_instalacion, instalacion.tipo_instalacion)
                && Objects.equals(this.ubicacion, instalacion.ubicacion)
                && Objects.equals(this.reservas, instalacion.reservas);
    }

    /**
     * Metodo que devuelve el hash de la instalacion
     *
     * @return el hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.tipo_instalacion , this.ubicacion, this.reservas);
    }

    /**
     * Metodo que indica la salida estandar al imprimir
     *
     * @return la salida estandar al imprimir
     */
    @Override
    public String toString() {
        return "Reserva{" + "id=" + this.id + ", nombre='" + this.nombre + '\''
                + ", ubicacion='" + this.ubicacion + '\'' + '}';
    }
}