//package ru.cbrcr.demorestservice.rest;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ru.cbrcr.demorestservice.entities.CreditOrganization;
//import ru.cbrcr.demorestservice.services.CreditOrganizationServiceImpl;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/api")
//public class CreditOrganizationController {
//
//    private final CreditOrganizationServiceImpl creditOrganizationServiceImpl;
//
//    @Autowired
//    public CreditOrganizationController(CreditOrganizationServiceImpl creditOrganizationServiceImpl) {
//        this.creditOrganizationServiceImpl = creditOrganizationServiceImpl;
//    }
//
//    @GetMapping("/credit-org/{id}")
//    public CreditOrganization getById(@PathVariable Long id) {
//        CreditOrganization creditOrganization = creditOrganizationServiceImpl.findById(id)
//                .orElseThrow(() -> new RuntimeException("По данному id организация не найдена"));
//        log.debug("По данному id получен: {}", creditOrganization.toString());
//        return creditOrganization;
//    }
//
//    @GetMapping("/credit-org")
//    public List<CreditOrganization> getAll() {
//        List<CreditOrganization> all = creditOrganizationServiceImpl.findAll();
//        all.forEach(co -> log.debug("Список всех КО: {}", co.toString()));
//        return all;
//    }
//
//    @GetMapping("/credit-org/name/{name}")
//    public CreditOrganization getByName(@PathVariable String name) {
//        return creditOrganizationServiceImpl.findByName(name);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void removeById(@PathVariable Long id) {
//        creditOrganizationServiceImpl.removeById(id);
//    }
//
//    @DeleteMapping("/delete/all")
//    public void removeAll() {
//        creditOrganizationServiceImpl.removeAll();
//    }
//}
