package com.web.wsc_backend.DTO.enterprise.request;

import com.web.wsc_backend.entity.Enterprises;
import lombok.Getter;

@Getter
public class EnterpriseSaveDTO {
    private String name;
    private String cnpj;

    public Enterprises toEntity() {
        Enterprises enterprise = new Enterprises();
        enterprise.setName(this.name);
        enterprise.setCnpj(this.cnpj);
        return enterprise;
    }
}
