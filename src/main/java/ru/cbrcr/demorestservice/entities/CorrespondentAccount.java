package ru.cbrcr.demorestservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "correspondent_account")
public class CorrespondentAccount {

    @Id
    @GeneratedValue(generator = "increment", strategy = GenerationType.SEQUENCE)
    //@GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private CreditOrganization creditOrganization;

    public CorrespondentAccount(Long number, String name) {
        this.number = number;
        this.name = name;
    }
}
