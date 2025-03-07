package com.web.wsc_backend.repository;

import com.web.wsc_backend.entity.Enterprises;
import com.web.wsc_backend.repository.interfaces.EnterpriseBasic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnterpriseRepository extends JpaRepository<Enterprises, Long> {
    List<EnterpriseBasic> findAllByOrderByName();
}
