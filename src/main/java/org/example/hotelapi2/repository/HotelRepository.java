package org.example.hotelapi2.repository;

import org.example.hotelapi2.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<Hotel> findByCategoria(String categoria);
    Optional<Hotel> findByLocalidad(String Localidad);
    Optional<Hotel>findById(int id);
}