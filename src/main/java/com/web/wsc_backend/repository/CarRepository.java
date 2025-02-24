package com.web.wsc_backend.repository;

import com.web.wsc_backend.entity.Cars;
import com.web.wsc_backend.enums.TypeEnum;
import com.web.wsc_backend.repository.queries.Queries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {
    @Query(Queries.FIND_CARS_BY_FILTERS)
    Page<Cars> findCarsByFilter(@Param("plate") String plate,
                                @Param("enterprise") String enterprise,
                                @Param("type") TypeEnum type,
                                @Param("startDate") LocalDate startDate,
                                @Param("endDate") LocalDate endDate,
                                Pageable pageable);
    @Query(Queries.FIND_TYPE_CARS_BY_FILTERS)
    List<TypeEnum> findByTypeByFilter(@Param("idEnterprise") Long idEnterprise,
                                      @Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);

}
