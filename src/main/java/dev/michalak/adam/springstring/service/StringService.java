package dev.michalak.adam.springstring.service;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import dev.michalak.adam.springstring.repository.StringRepository;
import dev.michalak.adam.springstring.repository.entity.StringData;
import org.springframework.stereotype.Service;

@Service
public class StringService {

    private final StringAnalyzer stringAnalyzer;
    private final StringRepository stringRepository;

    public StringService(StringAnalyzer stringAnalyzer, StringRepository stringRepository) {
        this.stringAnalyzer = stringAnalyzer;
        this.stringRepository = stringRepository;
    }

    public StringResponse process(StringRequest request) {
        StringResponse response = stringAnalyzer.analyze(request);

        stringRepository.save(new StringData(response.getConcatenatedResult()));

        return response;
    }
}
