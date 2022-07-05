package ru.cbr.demorestservice.domain.repository.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;
import ru.cbr.demorestservice.domain.service.CreditOrganizationServiceImpl;

@Slf4j
@Component
@RequiredArgsConstructor
@RepositoryEventHandler
public class CreditOrganizationRepositoryEventHandler {

    private final CreditOrganizationServiceImpl creditOrganizationService;
    private final CreditOrganizationRepository creditOrganizationRepository;

    @HandleBeforeSave
    public void handleCreditOrganizationBeforeSave(CreditOrganization creditOrganization) {
        creditOrganizationService.changeForm(creditOrganization.getId(), creditOrganization.getForm());
        String name = creditOrganization.getName();
        log.info("credit organization {} before save ",
                creditOrganization.toString());
    }

    @HandleBeforeCreate
    public void handleCreditOrganizationBeforeCreate(CreditOrganization creditOrganization) {
        log.info("credit organization before create");
        String name = creditOrganization.getName();
    }


    @HandleAfterSave
    public void handleCreditOrganizationAfterSave(CreditOrganization creditOrganization) {
        log.info("credit organization after save");
        String name = creditOrganization.getName();
    }
    @HandleAfterCreate
    public void handleCreditOrganizationAfterCreate(CreditOrganization creditOrganization) {
        log.info("credit organization after create");
        String name = creditOrganization.getName();
    }

    @HandleBeforeDelete
    public void handleCreditOrganizationBeforeDelete(CreditOrganization creditOrganization) {
        log.info("credit organization before delete");
        String name = creditOrganization.getName();
    }

    @HandleAfterDelete
    public void handleCreditOrganizationAfterDelete(CreditOrganization creditOrganization) {
        log.info("credit organization after delete");
        String name = creditOrganization.getName();
    }
}
