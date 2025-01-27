package org.example.hotelapi2.repository;

import org.example.hotelapi2.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    List<Habitacion> findByHotelIdAndOcupadaFalseAndTamanoAndPrecioNocheBetween(int hotelId, int tamano, double precioNocheAfter, double precioNocheBefore);


    Optional<Habitacion> findById(int id);
}