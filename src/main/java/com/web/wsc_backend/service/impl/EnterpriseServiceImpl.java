package com.web.wsc_backend.service.impl;

import com.web.wsc_backend.DTO.car.response.CarResponseDTO;
import com.web.wsc_backend.DTO.enterprise.request.EnterpriseSaveDTO;
import com.web.wsc_backend.DTO.enterprise.response.EnterpriseBasicDTO;
import com.web.wsc_backend.entity.Enterprises;
import com.web.wsc_backend.exceptions.runtime.PersistFailedException;
import com.web.wsc_backend.repository.EnterpriseRepository;
import com.web.wsc_backend.repository.interfaces.EnterpriseBasic;
import com.web.wsc_backend.service.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
    @Override
    public List<EnterpriseBasicDTO> findBasicInfoEnterprise() {

        List<EnterpriseBasic> enterpriseBasic = enterpriseRepository.findAllByOrderByName();

        return enterpriseBasic.stream().map(EnterpriseBasicDTO::new).toList();
    }

    @Override
    public EnterpriseBasicDTO save(EnterpriseSaveDTO enterpriseSaveDTO) {

        Enterprises enterprise;

        try {
            enterprise = enterpriseRepository.save(enterpriseSaveDTO.toEntity());
        } catch (Exception e) {
            throw new PersistFailedException("Fail when the enterprise was persisted");
        }
        return new EnterpriseBasicDTO(enterprise);
    }
}
