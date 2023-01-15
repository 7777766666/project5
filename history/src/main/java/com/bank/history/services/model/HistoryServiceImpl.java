package com.bank.history.services.model;

import com.bank.history.exception.ResourceNotFoundException;
import com.bank.history.mappers.HistoryMapper;
import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDTO;
import com.bank.history.repositories.HistoryRepository;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    public HistoryServiceImpl(HistoryRepository historyRepository,
                              HistoryMapper historyMapper) {
        this.historyRepository = historyRepository;
        this.historyMapper = historyMapper;
    }

    @Override
    public void save(HistoryDTO historyDTO) {
        History history = historyMapper.toEntity(historyDTO);
        historyRepository.save(history);
    }

    public HistoryDTO findById(Long id) {
        return HistoryMapper.HISTORY_MAPPER.toDto(historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with id " + id + " not found")));

    }


    @Transactional
    public HistoryDTO updateHistory(Long id, HistoryDTO historyDTO) {
        historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with id " + id + " not found"));
        History historyFromController = historyMapper.toEntity(historyDTO);
        historyFromController.setId(id);
        History historyUpdate = historyRepository.save(historyFromController);
        return historyMapper.toDto(historyUpdate);
    }

    @Override
    public HistoryDTO updatePartsHistory(Long id, HistoryDTO historyDTO) {
        History historyFromDB = historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with id " + id + " not found"));
        History historyUpdate = getHistoryFromHistoryDTOWithCheckOnNull(historyDTO, historyFromDB);
        History savedHistory = historyRepository.save(historyUpdate);
        return historyMapper.toDto(savedHistory);


    }


    @Override
    public List<HistoryDTO> getAll() {
        return historyRepository.findAll().stream()
                .map(historyMapper::toDto).collect(Collectors.toList());
    }

    private History getHistoryFromHistoryDTOWithCheckOnNull(HistoryDTO historyDTO, History history) {
        if (historyDTO.getAccountAuditId() != null) {
            history.setAccountAuditId(historyDTO.getAccountAuditId());

        }
        if (historyDTO.getAntiFraudAuditId() != null) {
            history.setAntiFraudAuditId(historyDTO.getAntiFraudAuditId());
        }

        if (historyDTO.getAuthorizationAuditId() != null) {
            history.setAuthorizationAuditId(historyDTO.getAuthorizationAuditId());
        }
        if (historyDTO.getTransferAuditId() != null) {
            history.setTransferAuditId(historyDTO.getTransferAuditId());
        }
        if (historyDTO.getPublicBankInfoAuditId() != null) {
            history.setPublicBankInfoAuditId(historyDTO.getPublicBankInfoAuditId());
        }
        if (historyDTO.getProfileAuditId() != null) {
            history.setProfileAuditId(historyDTO.getProfileAuditId());
        }
        return history;
    }
}