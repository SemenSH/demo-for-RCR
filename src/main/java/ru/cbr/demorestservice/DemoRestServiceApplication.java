package ru.cbr.demorestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;
import ru.cbr.demorestservice.domain.model.CreditOrganization;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class DemoRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestServiceApplication.class, args);
	}


//	@PostConstruct
//	public void init() {
//		CreditOrganization sber = new CreditOrganization( "SBER", "1111111111", CreditOrganizationType.BANK);
//		CorrespondentAccount ca = new CorrespondentAccount( 22333L, "acc#1");
//		CorrespondentAccount ca2 = new CorrespondentAccount(777888L, "acc#2");
//		DepartmentCbr departmentCbr = new DepartmentCbr(
//				"ГУ Банка России по Свердловской области", "65");
//		sber.setCorrespondentAccounts(List.of(ca, ca2));
//		sber.setDepartment(01L);
//
//		CreditOrganization vtb = new CreditOrganization( "VTB", "222222222", CreditOrganizationType.BANK);
//		CorrespondentAccount account1 = new CorrespondentAccount( 22333L, "acc#1");
//		CorrespondentAccount account2 = new CorrespondentAccount(777888L, "acc#2");
//		DepartmentCbr department = new DepartmentCbr(
//				"ГУ Банка России по Свердловской области", "08");
//		vtb.setCorrespondentAccounts(List.of(account1, account2));
//		vtb.setDepartment(02L);
//
//		List<CreditOrganization> list = new ArrayList<>();
//		list.add(sber);
//		list.add(vtb);
//		creditOrganizationRepository.saveAll(list);
//
//	}
}
