package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cbr.demorestservice.domain.model.DepartmentCBRF;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "departments", path = "departments")
public interface DepartmentCBRFRepo extends JpaRepository<DepartmentCBRF, Long> {

    List<DepartmentCBRF> findByName(@Param("name") String name);
}
