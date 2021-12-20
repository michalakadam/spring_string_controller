package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import dev.michalak.adam.springstring.repository.StringRepository;
import dev.michalak.adam.springstring.repository.entity.StringData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StringServiceTest {
    @Mock
    private StringAnalyzer stringAnalyzer;
    @Mock
    private StringRepository stringRepository;
    private StringService stringService;

    @BeforeEach
    void setUp() {
        this.stringService = new StringService(stringAnalyzer, stringRepository);
    }

    @Test
    void process_shouldCallDependenciesAndReturnValidResult() {
        var request = StringRequest.builder()
                .listsOfStrings(List.of(
                        List.of("abb", "aa", "zz"),
                        List.of("zz", "aa", "bba")
                ))
                .build();
        var expected = StringResponse.builder()
                .palindromePresent(true)
                .averageLength(2.34)
                .concatenatedResult("abbaazzzzaabba")
                .build();

        when(stringAnalyzer.analyze(request)).thenReturn(expected);
        var actual = stringService.process(request);

        assertEquals(expected, actual);
        verify(stringAnalyzer, times(1)).analyze(request);
        verify(stringRepository, times(1))
                .save(new StringData(expected.getConcatenatedResult()));
    }
}
