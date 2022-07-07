package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbr.demorestservice.domain.model.CreditOrganization;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface CreditOrganizationRepository extends JpaRepository<CreditOrganization, Long>,
        RevisionRepository<CreditOrganization, Long, Integer> {

    List<CreditOrganization> findByNameIgnoreCase(String name);
}
