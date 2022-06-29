package ru.cbr.demorestservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Component;
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

	@Component
	@Slf4j
	@RequiredArgsConstructor
	static class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

		@Override
		public void onApplicationEvent(ApplicationReadyEvent event) {
			log.debug(">>>>> ready >>>>>>>>>>>");
		}
	}
}
