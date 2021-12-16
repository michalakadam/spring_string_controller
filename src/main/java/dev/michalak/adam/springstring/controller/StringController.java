package dev.michalak.adam.springstring.controller;

import dev.michalak.adam.springstring.dto.StringRequest;
import dev.michalak.adam.springstring.dto.StringResponse;
import dev.michalak.adam.springstring.service.StringHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
public class StringController {

    private final StringHandler stringHandler;

    public StringController(StringHandler stringHandler) {
        this.stringHandler = stringHandler;
    }

    @PostMapping("concatenate")
    public StringResponse concatenate(@RequestBody StringRequest request) {
        log.info("Incoming {}", request.toString());

        return this.stringHandler.concatenate(request);
    }

    @PostMapping("palindrome")
    public boolean reverse(@NotNull String text) {
        log.info("Incoming word {}", text);

        return this.stringHandler.isPalindrome(text);
    }
}
