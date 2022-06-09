package ru.cbrcr.demorestservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "department_cb")
public class DepartmentCBRF {

    @Id
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    @Column
    private String name;
    @Column
    private String codeDepartment;
    @OneToOne(cascade = CascadeType.ALL)
    private CreditOrganization creditOrganization;

    public DepartmentCBRF(String name, String codeDepartment) {
        this.name = name;
        this.codeDepartment = codeDepartment;
    }
}
