package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "credit_organization")
public class CreditOrganization extends AbstractPersistable<Long> {

    @Column
    private String name;

    @Column
    private String regNumber;

    /**
     * Тип кредитной организации:
     * BANK;
     * RNKO;
     * PNKO;
     * NDKO;
     * NDKO-CK
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CreditOrganizationType creditOrganizationType;

    @JoinColumn(name = "creditOrganisation_id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CorrespondentAccount> correspondentAccounts = new HashSet<>();

    @Column
    private Long department;

    public CreditOrganization(String name, String regNumber, CreditOrganizationType type) {
        this.name = name;
        this.regNumber = regNumber;
        this.creditOrganizationType = type;
    }
}
