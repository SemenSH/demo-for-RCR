package ru.cbr.demorestservice.domain.model;

/**
 * Статус лицензии
 */
public enum LicenseStatus {

    /**
     * Лицензия активна
     */
    ACTIVE,
    /**
     * Лицензия отозвана
     */
    WITHDRAWN,
    /**
     * Лицензия аннулирована
     */
    ANNULLED,
    /**
     * Лицензия еще не получена, ожидается оплата уставного капитала
     */
    WAITING;

}
