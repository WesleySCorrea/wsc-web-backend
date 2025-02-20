package com.web.wsc_backend.controller;

import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping
    public ResponseEntity<Page<CarResponseDTO>> findAllCars(Pageable pageable) {

        return ResponseEntity.ok().body(carService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<CarResponseDTO> save(@RequestBody CarRequestDTO carRequest) {

        return ResponseEntity.ok().body(carService.save(carRequest));
    }
}
