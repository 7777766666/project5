package com.bank.history.models.dto;

import com.bank.history.models.History;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
/**
 * A Mapper для конвертации DTO в entity и назад{@link com.bank.history.models.History} entity
 * Интерфейс. Реализация генерируется в папке (history\target\generated-sources HistoryMapperImpl)
 * unmappedTargetPolicy - класс должен игнорироваться maven install(по факту не работает)
 * componentModel = "spring" - создавать компоненты спринга
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HistoryMapper {
    /**Метод конвертирует entity в DTO. Принимает entity возвращает ДТО*/
    History toEntity(HistoryDto historyDto);
    /**Метод конвертирует entity в DTO. Принимает ДТО возвращает entity */
    HistoryDto toDto(History history);
}
