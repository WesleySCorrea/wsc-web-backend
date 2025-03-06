package com.web.wsc_backend.controller;

import com.web.wsc_backend.DTO.enterprise.request.EnterpriseSaveDTO;
import com.web.wsc_backend.DTO.enterprise.response.EnterpriseBasicDTO;
import com.web.wsc_backend.service.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enterprise")
public class EnterpriseController {
    private final EnterpriseService enterpriseService;
    @GetMapping("/list")
    public ResponseEntity<List<EnterpriseBasicDTO>> findBasicInfoEnterprise() {

        List<EnterpriseBasicDTO> enterpriseBasicDTO = enterpriseService.findBasicInfoEnterprise();

        return ResponseEntity.ok().body(enterpriseBasicDTO);
    }

    @PostMapping
    public ResponseEntity<EnterpriseBasicDTO> save(@RequestBody EnterpriseSaveDTO enterpriseDTO) {

        EnterpriseBasicDTO enterprise = enterpriseService.save(enterpriseDTO);

        return ResponseEntity.ok().body(enterprise);
    }
}
