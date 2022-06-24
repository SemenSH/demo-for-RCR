package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

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

}
