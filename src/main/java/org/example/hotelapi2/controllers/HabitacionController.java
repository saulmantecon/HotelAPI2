package org.example.hotelapi2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotelapi2.model.Habitacion;
import org.example.hotelapi2.services.HabitacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    @Operation(summary = "Borrar una nueva habitacion", description = "Borra una nueva habitacion en un hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel borrado exitosamente"),
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

    public void updateHabitacionOcupada(@PathVariable int id) {
        try {
            habitacionService.updateHabitacionOcupada(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta");
        }
    }


    @GetMapping("hotel={idHotel}&tamano={tamano}&minPrecio={preciomin}&maxPrecio={preciomax}")
    @Operation(summary = "Buscar habitaciones disponibles", description = "Busca habitaciones no ocupadas que cumplan con el tamaño y el rango de precios especificado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de habitaciones obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron habitaciones")
    })
    public ResponseEntity<List<Habitacion>> buscarhabitacionesConCosas(@PathVariable int idHotel, @PathVariable int tamano, @PathVariable double preciomin, @PathVariable double preciomax) {
        try {
            return ResponseEntity.ok(habitacionService.getAllHabitaciones(idHotel, tamano, preciomin, preciomax));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta");
        }
    }


}
