package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StringHandler {

    public StringResponse concatenate(StringRequest request) {
        String concatenatedResult = request.getListsOfStrings().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining());

        return StringResponse.builder()
                .result(concatenatedResult)
                .build();
    }
}
