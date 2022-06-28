package ru.cbr.demorestservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.OrganizationForm;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreditOrganizationServiceImpl implements CreditOrganizationService {

    private CreditOrganizationRepository creditOrganizationRepository;

    @Autowired
    public CreditOrganizationServiceImpl(CreditOrganizationRepository creditOrganizationRepository) {
        this.creditOrganizationRepository = creditOrganizationRepository;
    }


    @Override
    @EventListener
    public void changeForm(String name, OrganizationForm form) {
        creditOrganizationRepository.findByName(name).setForm(form);
    }

    @Override
    @EventListener
    public void changeStatusLicense(String name, LicenseStatus status) {
        creditOrganizationRepository.findByName(name).setStatus(status);
    }
}
