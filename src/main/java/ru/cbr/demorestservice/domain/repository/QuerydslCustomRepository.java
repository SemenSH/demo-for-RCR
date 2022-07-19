package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.repository.query.Param;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.LicenseStatus;

import java.util.List;

public interface QuerydslCustomRepository {

    List<CreditOrganization> findByStatus(@Param("status")LicenseStatus status);
}
