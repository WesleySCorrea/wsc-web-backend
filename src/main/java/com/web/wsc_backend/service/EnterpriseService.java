package com.web.wsc_backend.service;

import com.web.wsc_backend.DTO.enterprise.request.EnterpriseSaveDTO;
import com.web.wsc_backend.DTO.enterprise.response.EnterpriseBasicDTO;

import java.util.List;

public interface EnterpriseService {

    List<EnterpriseBasicDTO> findBasicInfoEnterprise();
    EnterpriseBasicDTO save(EnterpriseSaveDTO enterpriseSaveDTO);
}
