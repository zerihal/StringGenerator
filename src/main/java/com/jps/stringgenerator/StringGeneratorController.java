package com.jps.stringgenerator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StringGeneratorController {

    private final StringGeneratorService stringGenService;

    public StringGeneratorController(StringGeneratorService strGenSvc) {
        this.stringGenService = strGenSvc;
    }

    // Endpoint for generating a random string of default length (50 chars) or specified length
    @GetMapping("/generate")
    public String getRandomString(HttpServletRequest request) {
        String query = request.getQueryString();

        if (query != null) {
            try {
                int length = Integer.parseInt(query);
                return stringGenService.generateRandomString(length);
            } catch (NumberFormatException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameter (integer expected)");
            }
        }
        
        return stringGenService.generateRandomString();
    }
}