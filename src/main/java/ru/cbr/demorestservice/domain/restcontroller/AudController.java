package ru.cbr.demorestservice.domain.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.repository.CreditOrganizationRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class AudController {

    private final CreditOrganizationRepository creditOrganizationRepository;

    /**
     * @param id
     * @return список модификаций+предыдущее состояние кредитной организации по id
     */
    @GetMapping("/clients/{id}/aud")
    public List<CreditOrganization> getAud(@PathVariable Long id) {
        return creditOrganizationRepository.findRevisions(id).stream()
                .map(Revision::getEntity)
                .collect(Collectors.toList());
    }
}
