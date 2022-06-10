package ru.cbrcr.demorestservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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

    @Column(name = "accountNumber", nullable = false)
    private Long accountNumber;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @ManyToOne()
    private CreditOrganization creditOrganization;

    public CorrespondentAccount(Long accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }
}
