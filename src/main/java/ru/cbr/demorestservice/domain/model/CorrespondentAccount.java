package ru.cbr.demorestservice.domain.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "correspondent_account")
public class CorrespondentAccount extends AbstractPersistable<Long> {

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "creditOrganisation_id")
    private Long creditOrganisationId;

    public CorrespondentAccount(Long number, String name) {
        this.number = number;
        this.name = name;
    }
}
