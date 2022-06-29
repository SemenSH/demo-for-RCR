package ru.cbr.demorestservice.domain.service;

import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.OrganizationForm;

public interface CreditOrganizationService {

    CreditOrganization changeForm(Long id, OrganizationForm form);

    CreditOrganization changeStatusLicense(Long id, LicenseStatus status);


}
