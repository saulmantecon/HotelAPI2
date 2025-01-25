package org.example.hotelapi2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.model.Hotel;
import org.example.hotelapi2.services.HabitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/habitacion")
@Tag(name = "habitaciones", description = "Catálogo de habitaciones ")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping("saveHabitacion")
    @Operation(summary = "Guardar una nueva habitacion", description = "Guarda una nueva habitacion en un hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public void saveHabitacion(@RequestBody Habitacion habitacion) {
        try {
            habitacionService.saveHabitacion(habitacion);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar una habitacion en un hotel", e);
        }
    }

    @DeleteMapping("deleteHabitacion")
    @Operation(summary = "Guardar una nueva habitacion", description = "Guarda una nueva habitacion en un hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public void deleteHabitacion(@RequestBody Habitacion habitacion) {
        try {
            habitacionService.deleteHabitacion(habitacion);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta");
        }
    }

    @PostMapping("updateHabitacionOcupada/{id}")
    @Operation(summary = "Actualizar estado de la habitacion", description = "Actualizar el estado de la habitacion a ocupada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })

    public void updateHabitacionOcupada(@PathVariable int id) {//ESTO NO FUNCIONA
        try {
            habitacionService.updateHabitacionOcupada(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta");
        }
    }


    @GetMapping("habitacion/{tamano}/{preciomin}/{preciomax}")
    @Operation(summary = "Buscar habitaciones disponibles",
            description = "Busca habitaciones no ocupadas que cumplan con el tamaño y el rango de precios especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de habitaciones obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron habitaciones")
    })
    public List<Habitacion> getAvailableRoomsByCriteria(
            @PathVariable @Parameter(description = "Tamaño de la habitación", example = "2") int tamano,
            @PathVariable @Parameter(description = "Precio mínimo por noche", example = "50.0") double preciomin,
            @PathVariable @Parameter(description = "Precio máximo por noche", example = "200.0") double preciomax) {
        if (tamano <= 0 || preciomin < 0 || preciomax < 0 || preciomin > preciomax) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parámetros inválidos");
        }
        try {
            List<Habitacion> habitaciones = habitacionService.findByOcupadaIsFalseAndTamanoAndPrecioNocheBetween(tamano, preciomin, preciomax);
            if (habitaciones.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron habitaciones");
            }
            return habitaciones;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al buscar habitaciones", e);
        }
    }

}
