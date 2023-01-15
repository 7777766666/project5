package com.bank.history.mappers;

import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T22:13:32+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public History toEntity(HistoryDTO historyDTO) {
        if ( historyDTO == null ) {
            return null;
        }

        History history = new History();

        history.setId( historyDTO.getId() );
        history.setTransferAuditId( historyDTO.getTransferAuditId() );
        history.setProfileAuditId( historyDTO.getProfileAuditId() );
        history.setAccountAuditId( historyDTO.getAccountAuditId() );
        history.setAntiFraudAuditId( historyDTO.getAntiFraudAuditId() );
        history.setPublicBankInfoAuditId( historyDTO.getPublicBankInfoAuditId() );
        history.setAuthorizationAuditId( historyDTO.getAuthorizationAuditId() );

        return history;
    }

    @Override
    public HistoryDTO toDto(History history) {
        if ( history == null ) {
            return null;
        }

        HistoryDTO historyDTO = new HistoryDTO();

        historyDTO.setId( history.getId() );
        historyDTO.setTransferAuditId( history.getTransferAuditId() );
        historyDTO.setProfileAuditId( history.getProfileAuditId() );
        historyDTO.setAccountAuditId( history.getAccountAuditId() );
        historyDTO.setAntiFraudAuditId( history.getAntiFraudAuditId() );
        historyDTO.setPublicBankInfoAuditId( history.getPublicBankInfoAuditId() );
        historyDTO.setAuthorizationAuditId( history.getAuthorizationAuditId() );

        return historyDTO;
    }
}
