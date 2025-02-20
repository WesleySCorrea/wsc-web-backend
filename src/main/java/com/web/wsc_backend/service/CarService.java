package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarResponseDTO> findAll(Pageable pageable);
    CarResponseDTO save(CarRequestDTO carRequestDTO);
}
