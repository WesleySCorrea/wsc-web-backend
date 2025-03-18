package com.web.wsc_backend.DTO.car.request;

import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateCarRequestDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String plate;
    @NotNull
    private Long year;
    @NotBlank
    private String chassis;
    @NotNull
    private TypeEnum type;

    public Cars toEntity() {
        Cars car = new Cars();
        car.setId(this.id);
        car.setPlate(this.plate);
        car.setYear(this.year);
        car.setChassis(this.chassis);
        car.setType(this.type);
        return car;
    }
}
