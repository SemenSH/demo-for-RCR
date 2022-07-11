package ru.cbr.demorestservice.domain.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import ru.cbr.demorestservice.domain.model.*;

import java.time.LocalDate;
import java.util.List;

@Projection(name = "full", types = {CreditOrganization.class})
public interface CreditOrganizationFullProjection {

    Long getId();

    String getCode();

    String getName();

    String getRegNumber();

    String getType();

    List<CorrespondentAccount> getCorrespondentAccounts();

    String getOGRN();

    OrganizationForm getForm();

    LocalDate getRegistrationDate();

    LicenseStatus getStatus();

    String getLocation();

    @Value("#{target.department.name}")
    String getDepartmentCbr();
}
