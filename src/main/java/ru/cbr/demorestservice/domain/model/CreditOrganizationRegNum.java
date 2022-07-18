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


@NoArgsConstructor
@AllArgsConstructor
@Audited
@Getter
@Setter
public class CreditOrganizationRegNum implements Serializable {

    @Column
    @Size(max = 4)
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[1-4](?: *, *[1-4])*$/")
    private String regNum;
}
