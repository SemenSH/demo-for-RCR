package ru.cbrcr.demorestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import ru.cbrcr.demorestservice.domain.model.CorrespondentAccount;
import ru.cbrcr.demorestservice.domain.model.CreditOrganization;
import ru.cbrcr.demorestservice.domain.model.CreditOrganizationType;
import ru.cbrcr.demorestservice.domain.model.DepartmentCBRF;
import ru.cbrcr.demorestservice.domain.repository.CreditOrganizationRepo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class DemoRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestServiceApplication.class, args);
	}

	@Autowired
	CreditOrganizationRepo creditOrganizationRepo;

	@PostConstruct
	public void init() {
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

		List<CreditOrganization> list = new ArrayList<>();
		list.add(sber);
		list.add(vtb);
		creditOrganizationRepo.saveAll(list);

	}
}
