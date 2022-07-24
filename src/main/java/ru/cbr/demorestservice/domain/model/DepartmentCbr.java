package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "departments")
@Audited
public class DepartmentCbr extends AbstractPersistable<Long> {

    @Column
    private String name;

    @Column
    private String code;

    @NotAudited
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<CreditOrganization> creditOrganizations = new ArrayList<>();

    public void addCreditOrganization(CreditOrganization organization) {
        if (creditOrganizations == null) {
            throw new NullPointerException("organization cannot be null");
        }
        if (organization.getDepartment() != null) {
            throw new IllegalStateException("organization is already registered in this department");
        }
        getCreditOrganizations().add(organization);
        organization.setDepartment(this);
    }
}
