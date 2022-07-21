package ru.cbr.demorestservice.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Getter
@Setter
public class Ogrn implements Serializable {

    @Column(nullable = false)
    @Size(min = 13, max = 13)
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[13](?: *, *[13])*$/")
    private String ogrnType;

}
