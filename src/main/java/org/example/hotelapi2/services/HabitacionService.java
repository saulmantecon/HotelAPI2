package org.example.hotelapi2.services;

import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.repository.HabitacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public void saveHabitacion(Habitacion habitacion) {
        System.out.println("habitacion recibida: " + habitacion);
        habitacionRepository.save(habitacion);
    }

    public void deleteHabitacion(Habitacion habitacion) {
        System.out.println("habitacion recibida: " + habitacion);
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

    public List<Habitacion> getAllHabitaciones(int hotelid, int tamano, double preciomin, double preciomax) {
        return habitacionRepository.findByHotelIdAndOcupadaFalseAndTamanoAndPrecioNocheBetween(hotelid, tamano, preciomin, preciomax);
    }


}
