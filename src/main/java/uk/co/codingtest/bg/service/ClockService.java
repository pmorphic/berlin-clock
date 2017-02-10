package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.bean.ClockDisplay;

@Service
public class ClockService {
    public ClockDisplay getDisplay(String time) {
        return new ClockDisplay();
    }
}
