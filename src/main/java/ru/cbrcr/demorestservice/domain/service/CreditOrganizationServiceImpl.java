package ru.cbrcr.demorestservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.cbrcr.demorestservice.domain.repository.CreditOrganizationRepo;
import ru.cbrcr.demorestservice.domain.model.CreditOrganization;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CreditOrganizationServiceImpl implements CreditOrganizationService{

    private CreditOrganizationRepo creditOrganizationRepo;

    @Autowired
    public CreditOrganizationServiceImpl(CreditOrganizationRepo creditOrganizationRepo) {
        this.creditOrganizationRepo = creditOrganizationRepo;
    }

    @Override
    public Optional<CreditOrganization> findById(Long id) {
        return creditOrganizationRepo.findById(id);
    }

    @Override
    public List<CreditOrganization> findAll() {
        return creditOrganizationRepo.findAll();
    }

    @Override
    public CreditOrganization findByName(String name) {
        return creditOrganizationRepo.findAll().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new RuntimeException("Организации с таким именем нет"));
        //TODO можно ли реализовать через метод-конструктор? Вариант с findByName отдает пустой лист или 1...
    }

    @Override
    public void removeById(Long id) {
        creditOrganizationRepo.deleteById(id);
    }

    @Override
    public void removeAll() {
        creditOrganizationRepo.deleteAll();
    }

    @Override
    public Page<CreditOrganization> findAtPage(int pageIndex, int rowCount, Sort.Direction direction, String sortField) {
        PageRequest request = PageRequest.of(pageIndex, rowCount, direction, sortField);
        return creditOrganizationRepo.findAll(request);
    }

    @Override
    public void save(CreditOrganization creditOrganization) {
        //TODO реализовать
    }

    @Override
    public List<CreditOrganization> findSame(CreditOrganization creditOrganization) {
        return creditOrganizationRepo.findAll(Example.of(creditOrganization));
    }
}
