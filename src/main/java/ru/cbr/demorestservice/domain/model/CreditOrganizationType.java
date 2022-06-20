package ru.cbr.demorestservice.domain.model;

/**
 * Виды кредитных организаций в РФ
 */
public enum CreditOrganizationType {
    /**
     * Банки
     */
    BANK,
    /**
     * Расчетные небанковские кредитные организации
     */
    RNKO,
    /**
     * Платежные небанковские кредитные организации
     */
    PNKO,
    /**
     * Небанковские депозитно-кредитные организации
     */
    NDKO,
    /**
     * Небанковские кредитные организации - центральные контрагенты
     */
    NKO_CK;
}