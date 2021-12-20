package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringAnalysisRequest;
import dev.michalak.adam.springstring.dto.StringAnalysisResponse;
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
        var request = StringAnalysisRequest.builder().listsOfStrings(List.of()).build();
        var expected = StringAnalysisResponse.builder().build();

        var actual = stringAnalyzer.analyze(request);

        assertEquals(expected, actual);
    }

    @Test
    void analyze_requestWithValidData_returnsProperlyPopulatedResponse() {
        var request = StringAnalysisRequest.builder()
                .listsOfStrings(List.of(
                        List.of("abb", "aa", "zz"),
                        List.of("zz", "aa", "bba")
                ))
                .build();
        var expected = StringAnalysisResponse.builder()
                .palindromePresent(true)
                .averageLength(2.34)
                .concatenatedResult("abbaazzzzaabba")
                .build();

        var actual = stringAnalyzer.analyze(request);

        assertEquals(expected, actual);
    }
}
