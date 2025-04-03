package org.wisleaf.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wisleaf.com.service.TimeToWordsRequestService;

@RestController
public class TimeToWordsRequestController {

    @Autowired
    private TimeToWordsRequestService timeToWordsRequestService;

    @PostMapping("/gettimeinwords")
    public ResponseEntity<String> convertCurrentTimeToWords(@RequestParam String time) {
        checkFormat(time);
        return timeToWordsRequestService.convertTimeToWords(time);
    }

    public void checkFormat(String time) {
        String timeRegex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
        if (!time.matches(timeRegex)) {
            throw new IllegalArgumentException("Invalid time format. Expected format is HH:MM.");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
