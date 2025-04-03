package org.wisleaf.com.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertTimeToWordsService {
    private static final Map<String, String> numberToWordsMap = new HashMap<>();
    static {
        numberToWordsMap.put("01", "one");
        numberToWordsMap.put("02", "two");
        numberToWordsMap.put("03", "three");
        numberToWordsMap.put("04", "four");
        numberToWordsMap.put("05", "five");
        numberToWordsMap.put("06", "six");
        numberToWordsMap.put("07", "seven");
        numberToWordsMap.put("08", "eight");
        numberToWordsMap.put("09", "nine");
        numberToWordsMap.put("10", "ten");
        numberToWordsMap.put("11", "eleven");
        numberToWordsMap.put("12", "twelve");
        numberToWordsMap.put("13", "thirteen");
        numberToWordsMap.put("14", "fourteen");
        numberToWordsMap.put("15", "fifteen");
        numberToWordsMap.put("16", "sixteen");
        numberToWordsMap.put("17", "seventeen");
        numberToWordsMap.put("18", "eighteen");
        numberToWordsMap.put("19", "nineteen");
        numberToWordsMap.put("20", "twenty");
        numberToWordsMap.put("30", "thirty");
        numberToWordsMap.put("40", "forty");
        numberToWordsMap.put("50", "fifty");
    }

    public ResponseEntity<String> convertTimeToWords(String time) {
        String timeInWords = "";
        try {
            if (time.equals("00:00") || time.equals("12:00")) {
                timeInWords = getMiddayAndNightInWords(time);
            } else {
                String[] parts = time.split(":");
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);

                String hoursInWords = convertNumberToWords(hours % 12 == 0 ? 12 : hours % 12);
                String minutesInWords = minutes == 0 ? "o'clock" : convertNumberToWords(minutes);

                timeInWords = "It's " + hoursInWords + (minutes == 0 ? "" : " " + minutesInWords);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(timeInWords, HttpStatus.OK);
    }

    private String convertNumberToWords(int number) {
        if (number <= 20) {
            return numberToWordsMap.get(String.format("%02d", number));
        } else {
            int tens = (number / 10) * 10;
            int ones = number % 10;
            String tensWord = numberToWordsMap.get(String.valueOf(tens));
            String onesWord = ones == 0 ? "" : numberToWordsMap.get(String.format("%02d", ones));
            return tensWord + (onesWord.isEmpty() ? " " : " "+ onesWord);
        }
    }

    public String getMiddayAndNightInWords(String time) {
        if (time.equals("00:00")) {
            return "It's Midnight";
        } else if (time.equals("12:00")) {
            return "It's Midday";
        }
        return "";
    }


}
