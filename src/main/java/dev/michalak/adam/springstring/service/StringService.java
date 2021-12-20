package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.PalindromesRequest;
import dev.michalak.adam.springstring.dto.StringAnalysisRequest;
import dev.michalak.adam.springstring.dto.StringAnalysisResponse;
import dev.michalak.adam.springstring.repository.StringRepository;
import dev.michalak.adam.springstring.repository.entity.PalindromeEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StringService {

    private final StringAnalyzer stringAnalyzer;
    private final StringRepository stringRepository;

    public StringService(StringAnalyzer stringAnalyzer, StringRepository stringRepository) {
        this.stringAnalyzer = stringAnalyzer;
        this.stringRepository = stringRepository;
    }

    public StringAnalysisResponse process(StringAnalysisRequest request) {
        StringAnalysisResponse response = stringAnalyzer.analyze(request);

        stringRepository.save(new PalindromeEntity(response.getConcatenatedResult()));

        return response;
    }

    public Iterable<PalindromeEntity> savePalindromes(PalindromesRequest request) {
        return stringRepository.saveAll(request.getPalindromes()
                .stream()
                .filter(stringAnalyzer::isPalindrome)
                .map(PalindromeEntity::new)
                .collect(Collectors.toList()));
    }
}
