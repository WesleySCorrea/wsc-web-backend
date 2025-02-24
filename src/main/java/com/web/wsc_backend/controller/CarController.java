package com.web.wsc_backend.controller;

import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.enums.TypeEnum;
import com.web.wsc_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping
    public ResponseEntity<Page<CarResponseDTO>> findCarsByFilter(
            @RequestParam(required = false) String plate,
            @RequestParam(required = false) String enterprise,
            @RequestParam(required = false) TypeEnum type,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            Pageable pageable) {

        return ResponseEntity.ok().body(carService.findCarsByFilter(
                plate,
                enterprise,
                type,
                startDate,
                endDate,
                pageable));
    }

    @PostMapping
    public ResponseEntity<CarResponseDTO> save(@RequestBody CarRequestDTO carRequest) {

        return ResponseEntity.ok().body(carService.save(carRequest));
    }

    @GetMapping("/types")
    public ResponseEntity<List<TypeEnum>> findTypesByFilter(
            @RequestParam(required = false) Long enterpriseId,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {

        List<TypeEnum> types = carService.findTypeByFilter(enterpriseId, startDate, endDate);

        return ResponseEntity.ok().body(types);
    }
}
