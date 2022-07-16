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
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Getter
@Setter
public class CreditOrganizationRegNum extends AbstractPersistable<Long> {

    @Column
    @Size(max = 4)
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[1-4](?: *, *[1-4])*$/")
    private String regNum;

    @OneToOne(fetch = FetchType.EAGER)
    private CreditOrganization creditOrganization;

    public CreditOrganizationRegNum(String regNum) {
    }
}
