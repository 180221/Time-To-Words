package org.wisleaf.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wisleaf.com.service.ConvertTimeToWordsService;

@Controller
public class ConvertTimeToWordsController {

    @Autowired
    private ConvertTimeToWordsService convertTimeToWordsService;

    @PostMapping("/converttimetowords")
    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
        return convertTimeToWordsService.convertTimeToWords(time);
    }

}
