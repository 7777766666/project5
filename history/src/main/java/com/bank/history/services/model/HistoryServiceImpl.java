package com.bank.history.services.model;

import com.bank.history.exception.ResourceNotFoundException;
import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDto;
import com.bank.history.models.dto.HistoryMapper;
import com.bank.history.repositories.HistoryRepository;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
/**
 *Класс сервисного слоя, реализующий методы HistoryService
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    /**Инжектим приватное финальное поле для обращения к historyRepository*/
    private final HistoryRepository historyRepository;
    /**Инжектим приватное финальное поле для обращения к historyMapper*/
    private final HistoryMapper historyMapper;
    /**используем внедрение зависимостей через конструктор*/
    public HistoryServiceImpl(HistoryRepository historyRepository,
                              HistoryMapper historyMapper) {
        this.historyRepository = historyRepository;
        this.historyMapper = historyMapper;
    }
    /**Конвертируем historyDTO в entity и сохраняем в базу данных*/
    @Override
    public void save(HistoryDto historyDto) {
        History history = historyMapper.toEntity(historyDto);
        historyRepository.save(history);
    }
    /**пробуем найти в базе данных по id entity history. Если найдена entityб возвращаем DTO
     * Если сущность не найдена, выбрасываем и обрабатываем исключение + пишем ошибку пользоватлю*/
    public HistoryDto findById(Long id) {
        return historyMapper.toDto(historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with " + id + "id not found")));
    }
    /**Пробуем найтии entity history по id. Если не находим, выбрасываем и обрабатываем исключение
     * Если сущность найдена, сохраняем в базу полученные для обновления поля*/
    @Transactional
    public HistoryDto updateHistory(Long id, HistoryDto historyDto) {
        historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History was not update, where id = " + id ));
        History historyFromController = historyMapper.toEntity(historyDto);
        historyFromController.setId(id);
        History historyUpdate = historyRepository.save(historyFromController);
        return historyMapper.toDto(historyUpdate);
    }
    /**метод ничего не принимает. Происходит преобразование всех сущностей из базы данных history
     * в поток/стрим и преобразование каждого элемента в лист historyDto */
    @Override
    public List<HistoryDto> getAll() {
        return historyRepository.findAll().stream()
                .map(historyMapper::toDto).collect(Collectors.toList());
    }
}
