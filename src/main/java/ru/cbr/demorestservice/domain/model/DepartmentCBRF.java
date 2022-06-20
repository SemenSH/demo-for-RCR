package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "departments")
public class DepartmentCBRF extends AbstractPersistable<Long> {

    @Column
    private String name;

    @Column
    private String code;

}
