package com.web.wsc_backend.service.impl;

import com.web.wsc_backend.DTO.enterprise.response.EnterpriseBasicDTO;
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

        List<EnterpriseBasic> enterpriseBasic = enterpriseRepository.findAllBy();

        return enterpriseBasic.stream().map(EnterpriseBasicDTO::new).toList();
    }
}
