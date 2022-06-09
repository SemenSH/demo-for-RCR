package ru.cbrcr.demorestservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "credit_organization")
public class CreditOrganization {

    @Id
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    @Column
    private String name;
    @Column
    private String regNumber;
    @JoinColumn(name = "correspondent_account_id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CorrespondentAccount> correspondentAccounts;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_cb_id")
    private DepartmentCBRF departmentCBRF;

    public CreditOrganization(String name, String regNumber) {
        this.name = name;
        this.regNumber = regNumber;
    }
}
