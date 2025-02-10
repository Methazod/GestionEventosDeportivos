package com.gestioneventosdeportivos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Modelo del usuario
 *
 * @author Jorge Manzano Anchelergues y Jaime Usero Aranda
 */
@Entity @Table(name = "usuario")
public class Usuario {

    /**
     * Id del Usuario
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre del Usuario
     */
    private String nombre;

    /**
     * Correo del usuario
     */
    private String email;

    /**
     * Eventos del usuario
     */
    @JsonIgnoreProperties("usuarios")
    @ManyToMany
    @JoinTable(
            name = "evento_usuario", // nombre tabla intermedia
            joinColumns = @JoinColumn(name = "usuario_id"), // id del usuario de la tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "evento_id") // id del evento de la tabla intermedia
    )
    private List<Evento> eventos = new ArrayList<>();

    /**
     * Construye un Usuario
     */
    public Usuario() {}

    /**
     * Construye un Usuario
     *
     * @param nombre del usuario
     * @param email del usuario
     */
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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
     * Getter del email
     *
     * @return el email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter de los eventos
     *
     * @return los eventos
     */
    public List<Evento> getEventos() { return this.eventos; }

    /**
     * Setter del id
     *
     * @param id el nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter del nombre
     *
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter del email
     *
     * @param email nuevo email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Setter de los eventos
     *
     * @param eventos nuevos eventos
     */
    public void setEventos(List<Evento> eventos) { this.eventos = eventos; }

    /**
     * Metodo que compara un usuario con este
     *
     * @param o el usuario a comparar
     * @return [true] si son iguales,
     * [false] si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Usuario))
            return false;
        Usuario user = (Usuario) o;
        return Objects.equals(this.id, user.id)
            && Objects.equals(this.nombre, user.nombre)
            && Objects.equals(this.email, user.email)
            && Objects.equals(this.eventos, user.eventos);
    }

    /**
     * Metodo que devuelve el hash del usuario
     *
     * @return el hash del usuario
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.email, this.eventos);
    }

    /**
     * Metodo que cambia la salida estandar al imprimir el usuario
     *
     * @return el usuario imprimido
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + this.id + ", nombre='" + this.nombre + '\''
                + ", correo='" + this.email + '\'' + '}';
    }
}