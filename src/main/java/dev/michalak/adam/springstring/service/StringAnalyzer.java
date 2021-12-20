package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringAnalysisRequest;
import dev.michalak.adam.springstring.dto.StringAnalysisResponse;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
class StringAnalyzer {

    StringAnalysisResponse analyze(StringAnalysisRequest request) {
        var listsOfStrings = request.getListsOfStrings();

        return StringAnalysisResponse.builder()
                .concatenatedResult(concatenate(listsOfStrings))
                .palindromePresent(isPalindromePresent(listsOfStrings))
                .averageLength(calculateAverageLength(listsOfStrings))
                .build();
    }

    private boolean isPalindromePresent(List<List<String>> listsOfStrings) {
        return listsOfStrings.stream()
                .flatMap(List::stream)
                .anyMatch(this::isPalindrome);
    }

    boolean isPalindrome(String text){
        String reversed = new StringBuilder(text).reverse().toString();

        return text.equals(reversed);
    }

    private double calculateAverageLength(List<List<String>> listsOfStrings) {
        double rawAverage = listsOfStrings.stream()
                .flatMap(List::stream)
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

    private String concatenate(List<List<String>> listsOfStrings) {
        return  listsOfStrings.stream()
                .flatMap(List::stream)
                .map(String::trim)
                .collect(Collectors.joining());
    }
}
