package com.bank.history.models.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.bank.history.models.History} entity
 * 7 столбцов, как в entity: 1 столбец - id=primary key
 * Остальные 6 столбцов Long, Nullable
 */
@Data
public class HistoryDto {
    private Long id;
    private Long transferAuditId;
    private Long profileAuditId;
    private Long accountAuditId;
    private Long antiFraudAuditId;
    private Long publicBankInfoAuditId;
    private Long authorizationAuditId;
}
