package com.web.wsc_backend.DTO.car.response;

import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.enums.TypeEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CarResponseDTO {
    private Long id;
    private String plate;
    private Long year;
    private String chassis;
    private Long enterpriseId;
    private TypeEnum type;
    private LocalDate maturity;

    public CarResponseDTO(Cars car) {
        this.id = car.getId();
        this.plate = car.getPlate();
        this.year = car.getYear();
        this.chassis = car.getChassis();
        this.enterpriseId = car.getEnterprise().getId();
        this.type = car.getType();
        this.maturity = car.getMaturity();
    }
}
