package ru.cbrcr.demorestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cbrcr.demorestservice.entities.DepartmentCBRF;

public interface DepartmentCBRFRepo extends JpaRepository<DepartmentCBRF, Long> {
}
