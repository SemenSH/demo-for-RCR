package ru.cbr.demorestservice.domain.model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
//@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@Entity(name = "correspondent_account")
public class CorrespondentAccount {

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

}
