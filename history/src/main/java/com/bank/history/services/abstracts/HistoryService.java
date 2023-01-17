package com.bank.history.services.abstracts;

import com.bank.history.models.dto.HistoryDto;
import java.util.List;
/**
 *Интерфейс сервисного слоя, методы которого будет реализовывать HistoryServiceImpl
 */
public interface HistoryService {
    /**Метод принимает historyDto, сохраняющего history в базу данных, ничего не возвращает*/
    void save(HistoryDto historydto);
    /**Метод принимает id и возвращает historyDto*/
    HistoryDto findById(Long id);
    /**Метод ничего не принимает и возвращает лист всех historyDto*/
    List<HistoryDto> getAll();
    /**Метод принимает id и historyDto и возвращает обновляет historyDto*/
    HistoryDto updateHistory(Long id, HistoryDto historydto);
}
