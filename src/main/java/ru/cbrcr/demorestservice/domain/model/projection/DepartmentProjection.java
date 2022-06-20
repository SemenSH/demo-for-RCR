package ru.cbrcr.demorestservice.domain.model.projection;

import org.springframework.data.rest.core.config.Projection;
import ru.cbrcr.demorestservice.domain.model.DepartmentCBRF;

@Projection(name = "nameDepartment", types = {DepartmentCBRF.class})
public interface DepartmentProjection {
    String getName();
}
