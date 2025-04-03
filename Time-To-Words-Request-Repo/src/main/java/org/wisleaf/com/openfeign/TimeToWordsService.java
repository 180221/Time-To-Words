package org.wisleaf.com.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="conversion-service")
public interface TimeToWordsService {

    @PostMapping("/converttimetowords")
    public ResponseEntity<String> convertTimeToWords(@RequestParam String time);
}
