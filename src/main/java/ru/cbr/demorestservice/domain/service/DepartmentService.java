package ru.cbr.demorestservice.domain.service;

import org.springframework.stereotype.Service;
import ru.cbr.demorestservice.domain.model.DepartmentCbr;
import ru.cbr.demorestservice.domain.repository.DepartmentCbrRepository;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentCbrRepository repo;

    public DepartmentService(DepartmentCbrRepository repo) {
        this.repo = repo;
    }

    public Optional<DepartmentCbr> getDepartmentById(Long id) {
        return repo.findById(id);
    }
}
