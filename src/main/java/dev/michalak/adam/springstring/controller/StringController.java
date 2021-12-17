package dev.michalak.adam.springstring.controller;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import dev.michalak.adam.springstring.service.StringAnalyzer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StringController {

    private final StringAnalyzer stringHandler;

    public StringController(StringAnalyzer stringHandler) {
        this.stringHandler = stringHandler;
    }

    @PostMapping("analyze")
    public StringResponse analyzeStringRequest(@RequestBody StringRequest request) {
        log.info("Incoming {}", request.toString());

        return stringHandler.analyze(request);
    }
}
