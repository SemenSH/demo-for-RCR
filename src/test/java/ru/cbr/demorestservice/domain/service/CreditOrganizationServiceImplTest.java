package ru.cbr.demorestservice.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.cbr.demorestservice.domain.event.DomainEvent;
import ru.cbr.demorestservice.domain.event.DomainEventListener;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.OrganizationForm;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@SpringBootTest
class CreditOrganizationServiceImplTest {
    @Autowired
    CreditOrganizationRepository creditOrganizationRepository;
    @Autowired
    private CreditOrganizationServiceImpl creditOrganizationService;
    @MockBean
    private DomainEventListener eventHandler;

    @Test
    @DisplayName("should publish and handle an entity event")
    public void changeForm() {

        //when
        CreditOrganization creditOrganization = creditOrganizationService.changeForm(10L, OrganizationForm.OOO);
        creditOrganizationRepository.save(creditOrganization);

        //then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
    }
}