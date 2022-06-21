package ru.cbr.demorestservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;
import ru.cbr.demorestservice.domain.model.CreditOrganization;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CreditOrganizationServiceImpl implements CreditOrganizationService{

    private CreditOrganizationRepository creditOrganizationRepository;

    @Autowired
    public CreditOrganizationServiceImpl(CreditOrganizationRepository creditOrganizationRepository) {
        this.creditOrganizationRepository = creditOrganizationRepository;
    }

    @Override
    public Optional<CreditOrganization> findById(Long id) {
        return creditOrganizationRepository.findById(id);
    }

    @Override
    public List<CreditOrganization> findAll() {
        return creditOrganizationRepository.findAll();
    }

    @Override
    public CreditOrganization findByName(String name) {
        return creditOrganizationRepository.findAll().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new RuntimeException("Организации с таким именем нет"));
        //TODO можно ли реализовать через метод-конструктор? Вариант с findByName отдает пустой лист или 1...
    }

    @Override
    public void removeById(Long id) {
        creditOrganizationRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        creditOrganizationRepository.deleteAll();
    }

    @Override
    public Page<CreditOrganization> findAtPage(int pageIndex, int rowCount, Sort.Direction direction, String sortField) {
        PageRequest request = PageRequest.of(pageIndex, rowCount, direction, sortField);
        return creditOrganizationRepository.findAll(request);
    }

    @Override
    public void save(CreditOrganization creditOrganization) {
        //TODO реализовать
    }

    @Override
    public List<CreditOrganization> findSame(CreditOrganization creditOrganization) {
        return creditOrganizationRepository.findAll(Example.of(creditOrganization));
    }
}
