package ru.cbrcr.demorestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cbrcr.demorestservice.entities.CreditOrganization;

import java.util.List;

@Repository
public interface CreditOrganizationRepo extends JpaRepository<CreditOrganization, Long> {

    CreditOrganization findByName(String name);
}
