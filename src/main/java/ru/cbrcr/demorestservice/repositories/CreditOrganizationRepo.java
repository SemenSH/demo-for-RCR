package ru.cbrcr.demorestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbrcr.demorestservice.entities.CreditOrganization;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface CreditOrganizationRepo extends JpaRepository<CreditOrganization, Long> {

    List<CreditOrganization> findByName(@Param("name") String name);
}
