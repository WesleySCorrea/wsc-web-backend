package com.web.wsc_backend.service.impl;

import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.enums.TypeEnum;
import com.web.wsc_backend.exceptions.runtime.PersistFailedException;
import com.web.wsc_backend.repository.CarRepository;
import com.web.wsc_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public Page<CarResponseDTO> findCarsByFilter(String plate, String enterprise, TypeEnum type, LocalDate endDate, Pageable pageable) {

        Page<Cars> carsPage = carRepository.findCarsByFilter(
                plate,
                enterprise,
                type,
                endDate,
                pageable);

        Page<CarResponseDTO> carsDTOpage = carsPage
                .map(CarResponseDTO::new);

        return carsDTOpage;
    }

    @Override
    public CarResponseDTO save(CarRequestDTO carRequestDTO) {

        Cars car;
        try {
            car = carRepository.save(carRequestDTO.toEntity());
        } catch (Exception e) {
        throw new PersistFailedException("Fail when the car was persisted");
    }
        return new CarResponseDTO(car);
    }

    @Override
    public CarResponseDTO findCarById(Long id) {

        Cars car;
        try {
            car = carRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Car not found");
        }
        return new CarResponseDTO(car);
    }

    @Override
    public List<TypeEnum> findTypeByFilter(String enterprise, LocalDate startDate, LocalDate endDate) {

        List<TypeEnum> types = carRepository.findByTypeByFilter(enterprise, startDate, endDate);

        return types;
    }
}
