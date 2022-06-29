package ru.cbr.demorestservice.domain.repository.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

@Slf4j
@Component
@RequiredArgsConstructor
@RepositoryEventHandler
public class CreditOrganizationRepositoryEventHandler {

    private final CreditOrganizationRepository creditOrganizationRepository;

    @HandleBeforeSave
    public void handleCreditOrganizationBeforeSave(CreditOrganization creditOrganization) {
        log.debug("credit organization before save");
        String name = creditOrganization.getName();
    }

    @HandleAfterSave
    public void handleCreditOrganizationAfterSave(CreditOrganization creditOrganization) {
        log.debug("credit organization after save");
        String name = creditOrganization.getName();
    }

    @HandleBeforeCreate
    public void handleCreditOrganizationBeforeCreate(CreditOrganization creditOrganization) {
        log.debug("credit organization before create");
        String name = creditOrganization.getName();
    }

    @HandleAfterCreate
    public void handleCreditOrganizationAfterCreate(CreditOrganization creditOrganization) {
        log.debug("credit organization after create");
        String name = creditOrganization.getName();
    }

    @HandleBeforeDelete
    public void handleCreditOrganizationBeforeDelete(CreditOrganization creditOrganization) {
        log.debug("credit organization before delete");
        String name = creditOrganization.getName();
    }

    @HandleAfterDelete
    public void handleCreditOrganizationAfterDelete(CreditOrganization creditOrganization) {
        log.debug("credit organization after delete");
        String name = creditOrganization.getName();
    }
}
