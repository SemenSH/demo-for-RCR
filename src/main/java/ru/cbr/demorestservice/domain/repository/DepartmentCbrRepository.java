package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.cbr.demorestservice.domain.model.DepartmentCbr;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "departments", path = "departments")
public interface DepartmentCbrRepository extends JpaRepository<DepartmentCbr, Long> {

    List<DepartmentCbr> findByName(@Param("name") String name);
}
