package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbr.demorestservice.domain.model.CreditOrganization;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface CreditOrganizationRepository extends JpaRepository<CreditOrganization, Long> {

    CreditOrganization findByNameIgnoreCase(String name);
}
