package com.web.wsc_backend.DTO.car.request;

import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.entity.Enterprises;
import com.web.wsc_backend.enums.TypeEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CarRequestDTO {
    private String plate;
    private Long year;
    private String chassis;
    private Long enterpriseId;
    private TypeEnum type;
    private LocalDate maturity;

    public Cars toEntity() {
        Cars car = new Cars();
        car.setPlate(this.plate);
        car.setYear(this.year);
        car.setChassis(this.chassis);
        Enterprises enterprise = new Enterprises();
        enterprise.setId(this.enterpriseId);
        car.setEnterprise(enterprise);
        car.setType(this.type);
        car.setMaturity(this.maturity);
        return car;
    }
}
