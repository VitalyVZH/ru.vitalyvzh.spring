package com.example.wordcount.controller;

import com.example.wordcount.service.CounterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping("/")
    public CounterResponse wordCounter(@RequestBody CounterRequest counterRequest) {

        Map<String, Long> stringLongMap = counterService.countWord(counterRequest.getText());

        CounterResponse response = new CounterResponse();
        response.setIdRequest(counterRequest.getIdRequest());
        response.setMapCounts(stringLongMap);
        return response;
    }
}
