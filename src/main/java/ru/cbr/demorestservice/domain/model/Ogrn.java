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
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Getter
@Setter
public class Ogrn extends AbstractPersistable<Long> {

    @Column
    @Size(min = 13,max = 13)
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[13](?: *, *[13])*$/")
    private String ogrn;

    @OneToOne(fetch = FetchType.EAGER)
    private CreditOrganization creditOrganization;

    public Ogrn(String ogrn) {
    }
}
