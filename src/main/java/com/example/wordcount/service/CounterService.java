package com.example.wordcount.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CounterService {

    public Map<String, Long> countWord(String input) {

        List<String> stringList = Arrays.asList(input.toLowerCase().split("\\W+"));
        Map<String, Long> result = new HashMap<>();

        for (String element : stringList) {
            if (result.containsKey(element)) {
                Long currentCount = result.get(element);
                result.put(element, currentCount + 1);
            } else {
                result.put(element, 1L);
            }
        }
        return result;
    }
}
