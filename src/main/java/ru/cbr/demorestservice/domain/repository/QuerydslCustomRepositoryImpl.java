package ru.cbr.demorestservice.domain.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import ru.cbr.demorestservice.domain.model.CreditOrganization;
import ru.cbr.demorestservice.domain.model.LicenseStatus;
import ru.cbr.demorestservice.domain.model.QCreditOrganization;

import java.util.List;

public class QuerydslCustomRepositoryImpl extends QuerydslRepositorySupport implements QuerydslCustomRepository {

    public QuerydslCustomRepositoryImpl() {
        super(CreditOrganization.class);
    }

    @Override
    public List<CreditOrganization> findByStatus(LicenseStatus status) {
        QCreditOrganization creditor = QCreditOrganization.creditOrganization;
        return from(creditor).where(creditor.status.eq(status)).fetch();
    }
}
