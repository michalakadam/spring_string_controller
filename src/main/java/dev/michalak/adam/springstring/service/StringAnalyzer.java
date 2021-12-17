package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StringAnalyzer {

    public StringResponse analyze(StringRequest request) {
        var listOfStrings = request.getListsOfStrings()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return StringResponse.builder()
                .palindromePresent(isPalindromePresent(listOfStrings))
                .averageLength(calculateAverageLength(listOfStrings))
                .concatenatedResult(concatenate(listOfStrings))
                .build();
    }

    private boolean isPalindromePresent(List<String> listOfStrings) {
        return listOfStrings.stream().anyMatch(this::isPalindrome);
    }

    public boolean isPalindrome(String text){
        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }

    private double calculateAverageLength(List<String> listOfStrings) {
        double rawAverage = listOfStrings.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);

        return roundUpToTwoDecimalPlaces(rawAverage);
    }

    private double roundUpToTwoDecimalPlaces(double rawValue) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        return Double.parseDouble(decimalFormat.format(rawValue));
    }

    private String concatenate(List<String> listOfStrings) {
        return  listOfStrings.stream()
                .map(String::trim)
                .collect(Collectors.joining());
    }
}
