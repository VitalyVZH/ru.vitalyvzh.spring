package com.example.wordcount;

import com.example.wordcount.controller.CounterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;

@DisplayName("Тест книги Властелин колец")
@SpringBootTest
@AutoConfigureMockMvc
public class FullBookSearchSpringTest {

    private final String path = "lotr.txt";

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Подсчет количества строк во всей книге!")
    @Test
    void check() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        String data = FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource(path).getFile()), "utf-8");
        CounterRequest counterRequest = new CounterRequest(1L, data);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/")
                .content(mapper.writerFor(CounterRequest.class).writeValueAsString(counterRequest))
                .contentType("application/json")
                .characterEncoding("utf-8")
        );

        // проверка статуса и наличия конкретной позиции
        result.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertThat(result.andReturn().getResponse().getContentAsString()).contains("\"taking\":67");
    }
}
