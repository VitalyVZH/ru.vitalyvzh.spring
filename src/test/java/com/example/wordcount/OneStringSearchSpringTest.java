package com.example.wordcount;

import com.example.wordcount.controller.CounterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@DisplayName("Тест функциональности")
@SpringBootTest
@AutoConfigureMockMvc
public class OneStringSearchSpringTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Проверка с использованием заглушки!")
    @Test
    void check() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        CounterRequest counterRequest = new CounterRequest(1L, "Grut! I am grut!");

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post("/")
                .content(mapper.writerFor(CounterRequest.class).writeValueAsString(counterRequest))
                .contentType("application/json")
        );

        // проверка статуса и сравнение содержимого
        result.andExpect(MockMvcResultMatchers.status().isOk());
        Assertions.assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo("{\"idRequest\":1,\"mapCounts\":{\"i\":1,\"grut\":2,\"am\":1}}");
    }
}
