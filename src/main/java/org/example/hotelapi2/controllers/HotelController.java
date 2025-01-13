package org.example.hotelapi2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotelapi2.model.Hotel;
import org.example.hotelapi2.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("api/hotel")
//la siguiente línea es para openAPI
@Tag(name = "hoteles", description = "Catálogo de hoteles")
public class HotelController {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("saveHotel")
    @Operation(summary = "Guardar un nuevo hotel", description = "Guarda un nuevo hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })
    public void saveHotel(@RequestBody @Parameter(description = "Datos del hotel a guardar", example = "{\"nombre\":\"hotelazo\"}") Hotel hotel) {
        try {
            hotelService.saveHotel(hotel);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar el nuevo hotel", e);
        }
    }


    @GetMapping("hotelPorCategoria/{categoria}")
    @Operation(summary = "Obtener hoteles por categoria", description = "Obtiene una lista de ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de autos obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron autos")
    })
    public Optional<Hotel> getHotelByCategory(@PathVariable @Parameter(description = "categoria del hotel", example = "categoria1") String categoria){
        try {
            return hotelService.findByCategoria(categoria);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta", e);
        }

    }

    @GetMapping("hotelPorLocalidad/{localidad}")
    @Operation(summary = "Obtener hoteles por categoria", description = "Obtiene una lista de ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de autos obtenida exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontraron autos")
    })
    public Optional<Hotel> getHotelByLocalidad(@PathVariable @Parameter(description = "localidad del hotel", example = "localidad1") String localidad){
        try {
            return hotelService.findByLocalidad(localidad);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta", e);
        }

    }




}


