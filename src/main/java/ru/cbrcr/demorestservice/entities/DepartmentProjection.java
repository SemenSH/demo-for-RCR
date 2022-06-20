package ru.cbrcr.demorestservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nameDepartment", types = {DepartmentCBRF.class})
public interface DepartmentProjection {

    String getName();
}
