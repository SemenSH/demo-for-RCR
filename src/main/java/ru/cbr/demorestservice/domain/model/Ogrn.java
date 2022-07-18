package ru.cbr.demorestservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Audited
@Getter
@Setter
public class Ogrn implements Serializable {

    @Column
    @Size(min = 13,max = 13)
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[13](?: *, *[13])*$/")
    private String ogrn;

}
