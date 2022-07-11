package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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

    @OneToMany(fetch = FetchType.EAGER)
    private List<CreditOrganization> creditOrganizations;

}
