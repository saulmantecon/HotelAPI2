package org.example.hotelapi2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.services.HabitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
}
