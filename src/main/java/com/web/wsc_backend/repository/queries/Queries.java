package com.web.wsc_backend.repository.queries;

public class Queries {
    public static final String FIND_CARS_BY_FILTERS ="""
            SELECT c FROM Cars c 
            JOIN c.enterprise e 
            WHERE (:plate IS NULL OR c.plate LIKE %:plate%)
            AND (:enterprise IS NULL OR e.name LIKE %:enterprise%)
            AND (:type IS NULL OR c.type = :type)
            AND (c.maturity <= COALESCE(:endDate, (SELECT MAX(c2.maturity) FROM Cars c2)))
            ORDER BY c.maturity DESC""";

    public static final String FIND_TYPE_CARS_BY_FILTERS ="""
            SELECT DISTINCT c.type FROM Cars c
            WHERE (:enterprise IS NULL OR c.enterprise.name = :enterprise)
            AND (c.maturity >= COALESCE(:startDate, (SELECT MIN(c2.maturity) FROM Cars c2)))
            AND (c.maturity <= COALESCE(:endDate, (SELECT MAX(c2.maturity) FROM Cars c2)))
            ORDER BY c.type ASC""";
}
