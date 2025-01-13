package org.example.hotelapi2.services;

import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }
    public void saveHabitacion(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    public void deleteHabitacion(Habitacion habitacion) {
        habitacionRepository.delete(habitacion);
    }

    public void updateHabitacionOcupada(Habitacion habitacion) {
        habitacion.setOcupada(true);
        habitacionRepository.save(habitacion);
    }

    public Optional<Habitacion> findHabitacionesPorTamanoYPrecio(int tamano, double precioNocheAfter, double precioNocheBefore){
        Optional<Habitacion> habitaciones = habitacionRepository.findByTamanoAndPrecioNocheBetween(tamano, precioNocheAfter, precioNocheBefore);
        habitaciones.map(habitacion -> new Habitacion(habitacion.getId()
                ,habitacion.getTamano()
                ,habitacion.getPrecioNoche()
                ,habitacion.isDesayuno()
                ,habitacion.isOcupada()
                ,habitacion.getHotel()
        ));
        return habitaciones;
    }

    public Optional<Habitacion> findBymuchascosas(int tamano, double precioNocheAfter, double precioNocheBefore){
        Optional<Habitacion> habitaciones = habitacionRepository.findByOcupadaIsFalseAndTamanoAndPrecioNocheBetween(tamano, precioNocheAfter, precioNocheBefore);
        return habitaciones.map(habitacion ->  new Habitacion(habitacion.getId()
                ,habitacion.getTamano()
                ,habitacion.getPrecioNoche()
                ,habitacion.isDesayuno()
                ,habitacion.isOcupada()
                ,habitacion.getHotel()
        ));
    }
}
