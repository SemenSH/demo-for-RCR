package ru.cbrcr.demorestservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "department_cb")
public class DepartmentCBRF {

    @Id
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @JsonIgnore
    @OneToMany()
    private List<CreditOrganization> creditOrganization = new ArrayList<>();

    public DepartmentCBRF(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
