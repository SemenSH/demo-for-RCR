package ru.cbr.demorestservice.domain.model.projection;

import org.springframework.data.rest.core.config.Projection;
import ru.cbr.demorestservice.domain.model.CreditOrganization;

@Projection(name = "regNumberAndName", types = { CreditOrganization.class })
public interface CreditOrganizationRegNumberAndNameProjection {

    String getRegNumber();

    String getName();
}
