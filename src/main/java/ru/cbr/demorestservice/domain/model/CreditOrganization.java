package ru.cbr.demorestservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cascade;
import org.hibernate.envers.Audited;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.cbr.demorestservice.domain.event.DomainEvent;
import ru.cbr.demorestservice.domain.event.DomainEventChangeLicenseStatus;
import ru.cbr.demorestservice.domain.event.DomainEventChangeOrganizationForm;
import ru.cbr.demorestservice.domain.model.converter.OgrnConverter;
import ru.cbr.demorestservice.domain.model.converter.RegNumConverter;
import ru.cbr.demorestservice.domain.type.CreditOrganizationRegNum;
import ru.cbr.demorestservice.domain.type.Ogrn;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Модель кредитной организации
 */
@Audited
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "credit_organization")
//@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = "credit_organization_graph",
        attributeNodes = {
                @NamedAttributeNode("department"),
                @NamedAttributeNode("correspondentAccounts"),
        })
public class CreditOrganization extends AbstractPersistable<Long> {

    /**
     * Предыдущее состояние объекта перед его поиском, изменением, загрузкой в контекст хранения
     */
    @Transient
    @JsonIgnore
    @ToString.Exclude
    private CreditOrganization previousState;

    public CreditOrganization(long l, String name) {
    }

    /**
     * Вызывается после загрузки объекта, поиска по id, изменения уже хранимого объекта,
     * сохраняет предыдущее состояние объекта
     */
    @PostLoad
    protected void postLoad() {
        previousState = new CreditOrganization();
        BeanUtils.copyProperties(this, previousState);
        log.info("\n>>>>>>>> postLoad complete -> previous state: {} with form {} ", this, this.getForm());
    }

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
     * Регистрационный номер
     */
    @Column
    @Convert(converter = RegNumConverter.class)
    private CreditOrganizationRegNum regNumber;

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
     * Список корреспондентских счетов организации
     */
    @ElementCollection(targetClass = CorrespondentAccount.class, fetch = FetchType.LAZY)
    private Collection<CorrespondentAccount> correspondentAccounts = new ArrayList<>();

    /**
     * ОГРН организации
     */
    @Column
    @Convert(converter = OgrnConverter.class)
    private Ogrn ogrn;

    /**
     * Организационно-правовая форма кредитной организации
     * возможные формы:
     * PAO;
     * NPAO;
     * OOO;
     * ZAO;
     * AO;
     * OAO;
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
     * Двунаправленная ссылка на департамент ЦБ, контролирующий данную организацию
     */
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "credit_organization_id")
    private DepartmentCbr department;

    /**
     * Список доменных событий
     */
    @Transient
    @JsonIgnore
    private Collection<DomainEvent> domainEvents = new ArrayList<>();

    /**
     * Изменение организационно-правовой формы кредитной организации и создание события
     * Например: АО -> ПАО
     *
     * @param form
     */
    public void changeOfOrganizationForm(OrganizationForm form) {
        this.form = form;
        domainEvents.add(new DomainEventChangeOrganizationForm());
    }

    /**
     * Изменение текущего статуса лицензии кредитной организации и создание события
     * Например: ACTIVE -> ANNULLED
     *
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
