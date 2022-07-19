package ru.cbr.demorestservice.domain.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.QCreditOrganization;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "creditOrganizations", path = "creditOrganizations")
public interface CreditOrganizationRepository extends CustomRepository<CreditOrganization, QCreditOrganization, Long>,
        RevisionRepository<CreditOrganization, Long, Integer> {

    @Override
    @EntityGraph(value = "credit_organization_graph", type = EntityGraph.EntityGraphType.FETCH)
    List<CreditOrganization> findAll();

    @Override
    @EntityGraph(value = "credit_organization_graph", type = EntityGraph.EntityGraphType.FETCH)
    Page<CreditOrganization> findAll(Predicate predicate, Pageable pageable);

    @Override
    @EntityGraph(value = "credit_organization_graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<CreditOrganization> findById(Long aLong);

    List<CreditOrganization> getCreditorByStatus(LicenseStatus status);
}
