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
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Getter
@Setter
public class CreditOrganizationRegNum implements Serializable {

    @Column(nullable = false)
    @Size(max = 4)
    // с пробелами @Pattern(regexp = "/^(?!.*(\\d).*\\1)[1-4](?: *, *[1-4])*$/")
    @Pattern(regexp = "/^(?!.*(\\d).*\\1)[1-4](?:,[1-4])*$/")
    private String regNumType;
}
