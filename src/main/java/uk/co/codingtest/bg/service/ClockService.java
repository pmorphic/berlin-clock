package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.bean.ClockDisplay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClockService {
    public ClockDisplay getDisplay(String time) {
        return new ClockDisplay();
    }
}
