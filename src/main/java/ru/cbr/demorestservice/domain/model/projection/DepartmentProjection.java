package ru.cbr.demorestservice.domain.model.projection;

import org.springframework.data.rest.core.config.Projection;
import ru.cbr.demorestservice.domain.model.DepartmentCbr;

@Projection(name = "name", types = {DepartmentCbr.class})
public interface DepartmentProjection {
    String getName();
}
