package org.wisleaf.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.wisleaf.com.openfeign.TimeToWordsService;

import java.util.HashMap;
import java.util.Map;

@Service
public class TimeToWordsRequestService {

    @Autowired
    TimeToWordsService timeToWordsService;


    public ResponseEntity<String> convertTimeToWords(String time) {
        String body = timeToWordsService.convertTimeToWords(time).getBody();
        return new ResponseEntity<>(body,HttpStatus.OK);

    }
}
