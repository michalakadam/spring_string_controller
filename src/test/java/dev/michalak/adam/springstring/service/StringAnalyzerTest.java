package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAnalyzerTest {
    private StringAnalyzer stringAnalyzer;

    @BeforeEach
    void setUp() {
        stringAnalyzer = new StringAnalyzer();
    }

    @Test
    void analyze_emptyListOfLists_returnsDefaultResponse() {
        // listsOfStrings is never null - 500 error is thrown at the controller level.
        var request = StringRequest.builder().listsOfStrings(List.of()).build();
        var expected = StringResponse.builder().build();

        var actual = stringAnalyzer.analyze(request);

        assertEquals(expected, actual);
    }

    @Test
    void analyze_requestWithValidData_returnsProperlyPopulatedResponse() {
        var listsOfStrings = List.of(
                List.of("abb", "aa", "zz"),
                List.of("zz", "aa", "bba")
        );
        var request = StringRequest.builder().listsOfStrings(listsOfStrings).build();
        var expected = StringResponse.builder()
                .palindromePresent(true)
                .averageLength(2.34)
                .concatenatedResult("abbaazzzzaabba")
                .build();

        var actual = stringAnalyzer.analyze(request);

        assertEquals(expected, actual);
    }
}
