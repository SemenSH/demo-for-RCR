package ru.cbrcr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbrcr.demorestservice.domain.model.CreditOrganization;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface CreditOrganizationRepo extends JpaRepository<CreditOrganization, Long> {

    List<CreditOrganization> findByName(@Param("name") String name);
}
