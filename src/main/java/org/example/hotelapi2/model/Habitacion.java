package org.example.hotelapi2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHabitacion")
    private int id;

    @Column(name = "tamano")
    private int tamano;

    @Column(name = "precioNoche")
    private double precioNoche;

    @Column(name = "desayuno")
    boolean desayuno;

    @Column(name = "ocupada")
    boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "idHotel", referencedColumnName = "idHotel")
    private Hotel hotel;

    public Habitacion() {
    }

    public Habitacion(int id, int tamano, double precioNoche, boolean desayuno, boolean ocupada, Hotel hotel) {
        this.id = id;
        this.tamano = tamano;
        this.precioNoche = precioNoche;
        this.desayuno = desayuno;
        this.ocupada = ocupada;
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", tamano=" + tamano +
                ", precioNoche=" + precioNoche +
                ", desayuno=" + desayuno +
                ", ocupada=" + ocupada +
                ", hotel=" + hotel +
                '}';
    }
}
