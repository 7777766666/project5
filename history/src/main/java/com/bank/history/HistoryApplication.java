package com.bank.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *Из данного класса мы запускаем наше приложение
 */
@SpringBootApplication
public class HistoryApplication {
    /**Метод запускающий приложение в контейнере*/
    public static void main(String[] args) {
        SpringApplication.run(HistoryApplication.class, args);
    }
}
