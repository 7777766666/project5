package com.bank.history.models.dto;

import com.bank.history.models.History;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-17T06:41:18+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public History toEntity(HistoryDto historyDto) {
        if ( historyDto == null ) {
            return null;
        }

        History history = new History();

        history.setId( historyDto.getId() );
        history.setTransferAuditId( historyDto.getTransferAuditId() );
        history.setProfileAuditId( historyDto.getProfileAuditId() );
        history.setAccountAuditId( historyDto.getAccountAuditId() );
        history.setAntiFraudAuditId( historyDto.getAntiFraudAuditId() );
        history.setPublicBankInfoAuditId( historyDto.getPublicBankInfoAuditId() );
        history.setAuthorizationAuditId( historyDto.getAuthorizationAuditId() );

        return history;
    }

    @Override
    public HistoryDto toDto(History history) {
        if ( history == null ) {
            return null;
        }

        HistoryDto historyDto = new HistoryDto();

        historyDto.setId( history.getId() );
        historyDto.setTransferAuditId( history.getTransferAuditId() );
        historyDto.setProfileAuditId( history.getProfileAuditId() );
        historyDto.setAccountAuditId( history.getAccountAuditId() );
        historyDto.setAntiFraudAuditId( history.getAntiFraudAuditId() );
        historyDto.setPublicBankInfoAuditId( history.getPublicBankInfoAuditId() );
        historyDto.setAuthorizationAuditId( history.getAuthorizationAuditId() );

        return historyDto;
    }
}
