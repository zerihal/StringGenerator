package com.jps.stringgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringGeneratorController {

    @Autowired
    StringGeneratorService stringGenService;

    @GetMapping("/generate")
    public String getRandomString() {
        return stringGenService.generateRandomString();
    }
    
}