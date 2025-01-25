package org.example.hotelapi2.services;

import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.model.Hotel;
import org.example.hotelapi2.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void updateHabitacionOcupada(int id) { // ESTO NO FUNCIONA
        Optional<Habitacion> habitacion = habitacionRepository.findById(id);
        if (habitacion.isPresent()) {
            Habitacion habitacionActual = habitacion.get();
            habitacionActual.setOcupada(true);
            habitacionRepository.save(habitacionActual);
        }
    }

    public Optional<Habitacion> findHabitacionesPorTamanoYPrecio(int tamano, double precioNocheAfter, double precioNocheBefore) {
        Optional<Habitacion> habitaciones = habitacionRepository.findByTamanoAndPrecioNocheBetween(tamano, precioNocheAfter, precioNocheBefore);
        return habitaciones.map(habitacion -> new Habitacion(habitacion.getId()
                , habitacion.getTamano()
                , habitacion.getPrecioNoche()
                , habitacion.isDesayuno()
                , habitacion.isOcupada()
                , habitacion.getHotel()
        ));
    }

    public List<Habitacion> findByOcupadaIsFalseAndTamanoAndPrecioNocheBetween(int tamano, double precioNocheAfter, double precioNocheBefore) {
        return habitacionRepository.findByOcupadaIsFalseAndTamanoAndPrecioNocheBetween(tamano, precioNocheAfter, precioNocheBefore)
                .stream()
                .map(habitacion -> new Habitacion(
                        habitacion.getId(),
                        habitacion.getTamano(),
                        habitacion.getPrecioNoche(),
                        habitacion.isDesayuno(),
                        habitacion.isOcupada(),
                        habitacion.getHotel()
                ))
                .collect(Collectors.toList());
    }


}
