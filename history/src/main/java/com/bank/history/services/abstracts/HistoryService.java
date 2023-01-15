package com.bank.history.services.abstracts;

import com.bank.history.models.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {

    void save(HistoryDTO historyDTO);

    HistoryDTO findById(Long id);

    List<HistoryDTO> getAll();
    HistoryDTO updateHistory(Long id, HistoryDTO historyDTO);

    HistoryDTO updatePartsHistory(Long id, HistoryDTO historyDTO);
}
