package ru.cbr.demorestservice.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.CreditOrganizationType;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.OrganizationForm;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Slf4j
@Component
@RequiredArgsConstructor
//@ConditionalOnProperty(value = "demorestservice.data.generation.enabled", havingValue = "true")
public class DataGenerator implements CommandLineRunner {

    private final CreditOrganizationRepository creditOrganizationRepository;
    private final List<CreditOrganization> creditOrganizations = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        generate();
    }

    public void generate() throws Exception {
        creditOrganizations.addAll(new CreditOrganizationCsv("data/creditOrganizations.csv")
                .read()
                .getModels());
        creditOrganizationRepository.saveAll(creditOrganizations);
        log.debug(">>> count of credit organizations: " + creditOrganizationRepository.count());
    }

    private class CreditOrganizationCsv extends BaseCsv<CreditOrganization> {

        public CreditOrganizationCsv(String filePath) {
            super(filePath);
        }

        @Override
        CreditOrganization create(String[] cols) {
            var creditOrg = new CreditOrganization();
            creditOrg.setType(CreditOrganizationType.valueOf(cols[1]));
            creditOrg.setRegNumber(cols[2]);
            creditOrg.setOGRN(cols[3]);
            creditOrg.setName(cols[4]);
            creditOrg.setForm(OrganizationForm.valueOf(cols[5]));
            creditOrg.setRegistrationDate(LocalDate.parse(cols[6]));
            creditOrg.setStatus(LicenseStatus.valueOf(cols[7]));
            creditOrg.setLocation(cols[8]);
            log.debug(">>>>>>>>>>>>>>>>>>>>>>> {}" + creditOrg.toString());
            return creditOrg;
        }
    }

    @RequiredArgsConstructor
    private abstract class BaseCsv<T> {
        @Getter
        protected final List<T> models = new ArrayList<>();
        private final String filePath;

        abstract T create(String[] cols);

        public BaseCsv<T> read() throws IOException {
            var scanner = new Scanner(
                    Objects.requireNonNull(getClass().getResourceAsStream(filePath)),
                    StandardCharsets.UTF_8).useDelimiter("\n");

            try {
                scanner.tokens().forEach(line -> models.add(create(line.split(","))));
            } finally {
                scanner.close();
            }
            return this;
        }
    }
}


