package com.bank.history.repositories;

import com.bank.history.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
/**
 *Интерфейс, наследующий JpaRepository для получения методов
 * findById и findById
 */
public interface HistoryRepository extends JpaRepository<History, Long> {
    /**Метод принимает id и возвращает опшинал в виде entity history или null*/
    Optional<History> findById(Long id);
    /**Метод ничего не принимает, а возвращает лист всех entity history.
     * может быть пустым*/
    List<History> findAll();
}
