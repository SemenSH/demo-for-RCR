package ru.cbrcr.demorestservice.services;

import org.springframework.stereotype.Service;
import ru.cbrcr.demorestservice.entities.DepartmentCBRF;
import ru.cbrcr.demorestservice.repositories.DepartmentCBRFRepo;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentCBRFRepo repo;

    public DepartmentService(DepartmentCBRFRepo repo) {
        this.repo = repo;
    }

    public Optional<DepartmentCBRF> getDepartmentById(Long id) {
        return repo.findById(id);
    }
}
