package com.bank.history.controllers;

import com.bank.history.models.dto.HistoryDto;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * Класс рест контроллеров, принимающий запросы от пользователей и возвращающий им
 * результаты обработки запросов. 4 метода: getHistoryById - возврат истории по принятому id,
 * getAll - возвращает все истории, updateHistory - обновляет истории в базе данных,
 * addHistory - добавляет пользователя в базу данных.
 */
@RestController
public class HistoryController {
    /** Приватное не изменяемое поле класса работы с сервисным слоем*/
    private final HistoryService historyService;
    /**Внедряем через конструктор бины из сервисного слоя*/
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }
    /**Метод Get принимает id пользователя и возвращает Dto сущности history
     * соответствующее введенному id*/
    @GetMapping(path = "/{id}")
    public HistoryDto getHistoryById(@PathVariable("id") Long id) {
        return historyService.findById(id);
    }
    /**Метод принимает GET запрос "all" и возвращает лист DTO всех историй*/
    @GetMapping(path = "/all")
    public ResponseEntity<List<HistoryDto>> getAll() {
        return ResponseEntity.ok(historyService.getAll());
    }
    /**Методом POST пользователь отправляет запрос в виде "save" + все данные для занесения
     * принятого DTO в базу (конвертируем DTO в entity и применяем метод save)*/
    @PostMapping(path = "/save")
    public void addHistory(@RequestBody HistoryDto historyDto) {
        historyService.save(historyDto);
    }
    /**Методом PUT пользователь отправляет запрос в виде "id"+" все данные, которые необходимо обновить
     * в базе данных. Принятое DTO сопоставляем с объектом в базе через entity и если объект
     * с таким id существем, обновляем базу данных*/
    @PutMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> updateHistory(@PathVariable("id") Long id, @RequestBody HistoryDto historyDto) {
        return ResponseEntity.ok(historyService.updateHistory(id, historyDto));
    }
}
