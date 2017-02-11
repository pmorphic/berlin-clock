package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;

@Service
public class DisplayEngine {
    public SecondsDisplay getSecondsDisplay(int seconds) {
        return (seconds % 2 == 0) ? SecondsDisplay.ON : SecondsDisplay.OFF;
    }

    public FiveHourDisplay get5HourDisplay(int hh24) {
        return FiveHourDisplay.fromDisplayState(hh24/5);
    }

}
