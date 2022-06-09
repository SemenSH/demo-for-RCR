package ru.cbrcr.demorestservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cbrcr.demorestservice.entities.CreditOrganization;
import ru.cbrcr.demorestservice.entities.services.CreditOrganizationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditOrganizationController {

    private final CreditOrganizationServiceImpl creditOrganizationServiceImpl;

    @Autowired
    public CreditOrganizationController(CreditOrganizationServiceImpl creditOrganizationServiceImpl) {
        this.creditOrganizationServiceImpl = creditOrganizationServiceImpl;
    }

    @GetMapping("/credit-org/{id}")
    public CreditOrganization getById(@PathVariable Long id) {
        return creditOrganizationServiceImpl.findById(id)
                .orElseThrow(() -> new RuntimeException("По данному id организация не найдена"));
    }

    @GetMapping("/credit-org")
    public List<CreditOrganization> getAll() {
        return creditOrganizationServiceImpl.findAll();
    }

    @GetMapping("/credit-org/name/{name}")
    public CreditOrganization getByName(@PathVariable String name) {
        return creditOrganizationServiceImpl.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void removeById(@PathVariable Long id) {
        creditOrganizationServiceImpl.removeById(id);
    }

    @DeleteMapping("/delete/all")
    public void removeAll() {
        creditOrganizationServiceImpl.removeAll();
    }
}
