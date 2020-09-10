package com.example.wordcount;

import com.example.wordcount.service.CounterService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@DisplayName("Тест книги Властелин колец")
public class FullBookSearchTest {

    private final String path = "lotr.txt";

    @DisplayName("Проверка поиска во всей книге без фреймворка!")
    @Test
    public void fullBookTest() throws IOException {
        CounterService counterService = new CounterService();
        String data = FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource(path).getFile()), "utf-8");

        Map<String, Long> stringLongMap = counterService.countWord(data);
        Assertions.assertEquals(577L, stringLongMap.get("ring"));

    }
}
