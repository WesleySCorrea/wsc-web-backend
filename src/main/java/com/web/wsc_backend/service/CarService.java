package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.enums.TypeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    Page<CarResponseDTO> findCarsByFilter(
            String plate,
            String enterprise,
            TypeEnum type,
            LocalDate startDate,
            LocalDate endDate,
            Pageable pageable);
    CarResponseDTO save(CarRequestDTO carRequestDTO);
    List<TypeEnum> findTypeByFilter(Long enterpriseId, LocalDate startDate, LocalDate endDate);
}
