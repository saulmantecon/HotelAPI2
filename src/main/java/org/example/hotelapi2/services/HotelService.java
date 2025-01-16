package org.example.hotelapi2.services;

import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.model.Hotel;
import org.example.hotelapi2.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository, HotelRepository hotelRepository1) {
        this.hotelRepository = hotelRepository1;
    }

    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }


    public Optional<Hotel> findByCategoria(String categoria) {
        Optional<Hotel> hotelOptional = hotelRepository.findByCategoria(categoria);
        return hotelOptional.map(hotel -> new Hotel(hotel.getId(), hotel.getNombre(), hotel.getDescripcion(), hotel.getCategoria(), hotel.isPiscina(), hotel.getLocalidad()));
    }

    public Optional<Hotel> findByLocalidad(String Localidad) {
        Optional<Hotel> hotelOptional = hotelRepository.findByLocalidad(Localidad);
        return hotelOptional.map(hotel -> new Hotel(hotel.getId(), hotel.getNombre(), hotel.getDescripcion(), hotel.getCategoria(), hotel.isPiscina(), hotel.getLocalidad()));
    }



}
