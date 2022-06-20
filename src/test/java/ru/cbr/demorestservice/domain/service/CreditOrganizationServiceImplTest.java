package ru.cbr.demorestservice.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import ru.cbr.demorestservice.domain.model.CorrespondentAccount;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.CreditOrganizationType;
import ru.cbr.demorestservice.domain.model.DepartmentCBRF;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreditOrganizationServiceImplTest {
    @Autowired
    private CreditOrganizationServiceImpl creditOrganizationService;

    @BeforeEach
    void setUp() {
        CreditOrganization sber = new CreditOrganization( "SBER", "1111111111", CreditOrganizationType.BANK);
        CorrespondentAccount ca = new CorrespondentAccount( 22333L, "acc#1");
        CorrespondentAccount ca2 = new CorrespondentAccount(777888L, "acc#2");
        DepartmentCBRF departmentCBRF = new DepartmentCBRF(
                "ГУ Банка России по Свердловской области", "65");
        sber.setCorrespondentAccounts(Set.of(ca, ca2));
        sber.setDepartment(01L);

        CreditOrganization vtb = new CreditOrganization( "VTB", "222222222", CreditOrganizationType.BANK);
        CorrespondentAccount account1 = new CorrespondentAccount( 22333L, "acc#1");
        CorrespondentAccount account2 = new CorrespondentAccount(777888L, "acc#2");
        DepartmentCBRF department = new DepartmentCBRF(
                "ГУ Банка России по Свердловской области", "08");
        vtb.setCorrespondentAccounts(Set.of(account1, account2));
        vtb.setDepartment(02L);
    }

    @Test
    public void should_split_by_page_asc() {
        boolean founded = creditOrganizationService.findAtPage(1,1,
                Sort.Direction.ASC, "name")
                .get().anyMatch(co -> co.getName().equals("VTB"));

        assertTrue(founded);
    }
}