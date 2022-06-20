//package ru.cbrcr.demorestservice.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.cbrcr.demorestservice.entities.DepartmentCBRF;
//import ru.cbrcr.demorestservice.services.DepartmentService;
//
//import java.util.function.Supplier;
//
//@RestController
//@RequestMapping("/api")
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentService departmentService;
//
//    @GetMapping("department/{id}")
//    public DepartmentCBRF findById(@PathVariable Long id) {
//        return departmentService.getDepartmentById(id).orElseThrow(
//                () -> new RuntimeException("По такому id нет подразделения"));
//    }
//}
