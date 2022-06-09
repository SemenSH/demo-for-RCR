package ru.cbrcr.demorestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cbrcr.demorestservice.entities.CorrespondentAccount;

@Repository
public interface CorrAccountRepo extends JpaRepository<CorrespondentAccount, Long> {
}
