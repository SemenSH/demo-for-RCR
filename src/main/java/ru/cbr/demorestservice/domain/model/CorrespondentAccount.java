package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "correspondent_account")
public class CorrespondentAccount extends AbstractPersistable<Long> {

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

}
