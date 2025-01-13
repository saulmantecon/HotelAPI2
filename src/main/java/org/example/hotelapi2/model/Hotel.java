package org.example.hotelapi2.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name ="descripcion")
    private String descripcion;

    @Column(name = "categoria")
    private String categoria;

    @Column(name ="piscina" )
    private boolean piscina;

    @Column(name = "localidad")
    private String localidad;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Habitacion> listaHabitaciones;

    public Hotel() {

    }

    public Hotel(int id, String nombre, String descripcion, String categoria, boolean piscina, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.piscina = piscina;
        this.localidad = localidad;
    }

    public Hotel(int id, List<Habitacion> listaHabitaciones) {
        this.id = id;
        this.listaHabitaciones = listaHabitaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", piscina=" + piscina +
                ", localidad='" + localidad + '\'' +
                ", listaHabitaciones=" + listaHabitaciones +
                '}';
    }
}//hotel
