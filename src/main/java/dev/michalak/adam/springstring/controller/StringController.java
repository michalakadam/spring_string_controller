package dev.michalak.adam.springstring.controller;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import dev.michalak.adam.springstring.service.StringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringController.class);

    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @PostMapping("analyze")
    public ResponseEntity<StringResponse> analyzeStrings(@RequestBody StringRequest request) {
        LOGGER.info("Incoming {}", request.toString());

        return ResponseEntity.ok(stringService.process(request));
    }
}
