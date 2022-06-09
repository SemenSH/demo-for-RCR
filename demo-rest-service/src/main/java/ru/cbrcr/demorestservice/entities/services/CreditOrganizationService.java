package ru.cbrcr.demorestservice.entities.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.cbrcr.demorestservice.entities.CreditOrganization;

import java.util.List;
import java.util.Optional;

public interface CreditOrganizationService {

    Optional<CreditOrganization> findById(Long id);
    Page<CreditOrganization> findAtPage(int pageIndex, int rowCount, Sort.Direction direction, String sortField);
    void save(CreditOrganization creditOrganization);
    List<CreditOrganization> findSame(CreditOrganization creditOrganization);
    List<CreditOrganization> findAll();
    CreditOrganization findByName(String name);
    void removeAll();
    void removeById(Long id);


}
