package ru.cbr.demorestservice.domain.service;

import org.springframework.stereotype.Service;
import ru.cbr.demorestservice.domain.model.DepartmentCBRF;
import ru.cbr.demorestservice.domain.repository.DepartmentCBRFRepo;

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
