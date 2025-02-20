package com.web.wsc_backend.service.impl;

import com.web.wsc_backend.DTO.car.request.CarRequestDTO;
import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.exceptions.runtime.PersistFailedException;
import com.web.wsc_backend.repository.CarRepository;
import com.web.wsc_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public Page<CarResponseDTO> findAll(Pageable pageable) {

        Page<Cars> carsPage = carRepository.findAll(pageable);

        Page<CarResponseDTO> carsDTOpage = carsPage
                .map(CarResponseDTO::new);

        return carsDTOpage;
    }

    @Override
    public CarResponseDTO save(CarRequestDTO carRequestDTO) {

        Cars car = new Cars();

        try {
            car = carRepository.save(carRequestDTO.toEntity());
        } catch (Exception e) {
        throw new PersistFailedException("Fail when the car was persisted");
    }

        return new CarResponseDTO(car);
    }
}
