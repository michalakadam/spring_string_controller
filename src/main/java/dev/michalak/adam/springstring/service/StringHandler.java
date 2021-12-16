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
                .map(String::trim)
                .collect(Collectors.joining());

        return StringResponse.builder()
                .result(concatenatedResult)
                .build();
    }

    public boolean isPalindrome(String text){
        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }
}
