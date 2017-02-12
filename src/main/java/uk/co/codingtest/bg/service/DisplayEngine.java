package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.FiveMinuteDisplay;
import uk.co.codingtest.bg.enums.OneTimeUnitDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;

@Service
public class DisplayEngine {
    public SecondsDisplay getSecondsDisplay(int seconds) {
        return (seconds % 2 == 0) ? SecondsDisplay.ON : SecondsDisplay.OFF;
    }

    public FiveHourDisplay get5HourDisplay(int hh24) {
        return FiveHourDisplay.fromDisplayState(hh24 / 5);
    }

    public OneTimeUnitDisplay get1HourDisplay(int hh24) {
        return OneTimeUnitDisplay.fromDisplayState(hh24 % 5);
    }

    public FiveMinuteDisplay get5MinuteDisplay(int mi) {
        return FiveMinuteDisplay.fromDisplayState(mi / 5);
    }

    public OneTimeUnitDisplay get1MinuteDisplay(int mi) {
        return OneTimeUnitDisplay.fromDisplayState(mi % 5);
    }
}
