package ru.cbrcr.demorestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.cbrcr.demorestservice.entities.CorrespondentAccount;
import ru.cbrcr.demorestservice.entities.CreditOrganization;
import ru.cbrcr.demorestservice.entities.DepartmentCBRF;
import ru.cbrcr.demorestservice.repositories.CreditOrganizationRepo;
import ru.cbrcr.demorestservice.repositories.DepartmentCBRFRepo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestServiceApplication.class, args);
	}

	@Autowired
	CreditOrganizationRepo creditOrganizationRepo;

	@PostConstruct
	public void init() {
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

		List<CreditOrganization> list = new ArrayList<>();
		list.add(sber);
		list.add(vtb);
		creditOrganizationRepo.saveAll(list);

	}
}
