package dev.michalak.adam.springstring.controller;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StringController {

    @PostMapping("concatenate")
    public StringResponse concatenate(StringRequest request) {
        log.info("Incoming {}", request.toString());

        return null;
    }

    @PostMapping("reverse")
    public StringResponse reverse(StringRequest request) {
        log.info("Incoming {}", request.toString());

        return null;
    }
}
