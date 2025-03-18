package com.web.wsc_backend.DTO.car.request;

import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.entity.Enterprises;
import com.web.wsc_backend.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CarRequestDTO {

    @NotBlank
    private String plate;
    @NotNull
    private Long year;
    @NotBlank
    private String chassis;
    @NotNull
    private Long enterpriseId;
    @NotNull
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
