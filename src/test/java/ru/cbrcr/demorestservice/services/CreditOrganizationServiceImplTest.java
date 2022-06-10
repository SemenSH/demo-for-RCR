package ru.cbrcr.demorestservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import ru.cbrcr.demorestservice.entities.CorrespondentAccount;
import ru.cbrcr.demorestservice.entities.CreditOrganization;
import ru.cbrcr.demorestservice.entities.DepartmentCBRF;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreditOrganizationServiceImplTest {
    @Autowired
    private CreditOrganizationServiceImpl creditOrganizationService;

    @BeforeEach
    void setUp() {
        CreditOrganization sber = new CreditOrganization( "SBER", "1111111111");
        CorrespondentAccount ca = new CorrespondentAccount( 22333L, "acc#1");
        CorrespondentAccount ca2 = new CorrespondentAccount(777888L, "acc#2");
        DepartmentCBRF departmentCBRF = new DepartmentCBRF(
                "ГУ Банка России по Свердловской области", "65");
        sber.setCorrespondentAccounts(Set.of(ca, ca2));
        sber.setDepartmentCBRF(departmentCBRF);

        CreditOrganization vtb = new CreditOrganization( "VTB", "222222222");
        CorrespondentAccount account1 = new CorrespondentAccount( 22333L, "acc#1");
        CorrespondentAccount account2 = new CorrespondentAccount(777888L, "acc#2");
        DepartmentCBRF department = new DepartmentCBRF(
                "ГУ Банка России по Свердловской области", "08");
        vtb.setCorrespondentAccounts(Set.of(account1, account2));
        vtb.setDepartmentCBRF(department);
    }

    @Test
    public void should_split_by_page_asc() {
        boolean founded = creditOrganizationService.findAtPage(1,1,
                Sort.Direction.ASC, "name")
                .get().anyMatch(co -> co.getName().equals("VTB"));

        assertTrue(founded);
    }
}