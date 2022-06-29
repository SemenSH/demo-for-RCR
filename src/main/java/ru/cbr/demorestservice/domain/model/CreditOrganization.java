package ru.cbr.demorestservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.cbr.demorestservice.domain.event.DomainEvent;
import ru.cbr.demorestservice.domain.event.DomainEventChangeLicenseStatus;
import ru.cbr.demorestservice.domain.event.DomainEventChangeOrganizationForm;
import ru.cbr.demorestservice.domain.service.CreditOrganizationServiceImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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

    @Transient
    @JsonIgnore
    private Collection<DomainEvent> domainEvents = new ArrayList<>();

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
     * возможные формы:
     *     PAO;
     *     NPAO;
     *     OOO;
     *     ZAO;
     *     AO;
     *     OAO;
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

    /**
     * Изменение организационно-правовой формы кредитной организации и создание события
     * Например: АО -> ПАО
     * @param form
     */
    public void changeOfOrganizationForm(OrganizationForm form) {
        this.form = form;
        domainEvents.add(new DomainEventChangeOrganizationForm());
    }

    /**
     * Изменение текущего статуса лицензии кредитной организации и создание события
     * Например: ACTIVE -> ANNULLED
     * @param status
     */
    public void changeOfLicense(LicenseStatus status) {
        this.status = status;
        domainEvents.add(new DomainEventChangeLicenseStatus());
    }

    @DomainEvents
    public Collection<DomainEvent> events() {
        return domainEvents;
    }

    @AfterDomainEventPublication
    public void clearEvents() {
        domainEvents.clear();
    }

}
