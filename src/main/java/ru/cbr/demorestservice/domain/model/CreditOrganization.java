package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель кредитной организации
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "credit_organization")
public class CreditOrganization extends AbstractPersistable<Long> {

    /**
     * Код кредитной организации
     */
    @Column
    private String code;
    /**
     * Наименование кредитной организации
     */
    @Column
    private String name;

    /**
     *  Регистрационный номер
     */
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
    private CreditOrganizationType type;

    /**
     *  Список корреспондентских счетов организации
     */
    @JoinColumn(name = "credit_organization_id")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CorrespondentAccount> correspondentAccounts = new ArrayList<>();

    /**
     *  ОГРН организации
     */
    @Column
    private String OGRN;

    /**
     * Организационно-правовая форма кредитной организации
     */
    @Column(name = "form")
    @Enumerated(EnumType.STRING)
    private OrganizationForm form;

    /**
     * Дата регистрации в ЦБ
     */
    @Column
    private LocalDate registrationDate;

    /**
     * Статус лицензии
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LicenseStatus status;

    /**
     * Местонахождение организации
     */
    @Column
    private String location;

    /**
     *  Однонаправленная ссылка на департамент ЦБ, контролирующий данную организацию
     */
    @Column
    private Long department;

}
