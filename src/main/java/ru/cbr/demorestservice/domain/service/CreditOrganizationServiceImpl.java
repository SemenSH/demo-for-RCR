package ru.cbr.demorestservice.domain.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.OrganizationForm;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CreditOrganizationServiceImpl implements CreditOrganizationService {

    private CreditOrganizationRepository creditOrganizationRepository;

    @Autowired
    public CreditOrganizationServiceImpl(CreditOrganizationRepository creditOrganizationRepository) {
        this.creditOrganizationRepository = creditOrganizationRepository;
    }


    @Override
    public CreditOrganization changeForm(Long id, @NonNull OrganizationForm form) {
        CreditOrganization co = creditOrganizationRepository.findById(id).orElseThrow();
        co.changeOfOrganizationForm(form);
        creditOrganizationRepository.save(co);
        return co;
    }

    @Override
    public CreditOrganization changeStatusLicense(Long id, @NonNull LicenseStatus status) {
        CreditOrganization co = creditOrganizationRepository.findById(id).orElseThrow();
        co.changeOfLicense(status);
        creditOrganizationRepository.save(co);
        return co;
    }
}
