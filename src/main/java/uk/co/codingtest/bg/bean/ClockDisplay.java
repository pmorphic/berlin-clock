package uk.co.codingtest.bg.bean;

import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;

public class ClockDisplay {
    private SecondsDisplay secondsDisplay = SecondsDisplay.OFF;
    private FiveHourDisplay fiveHourDisplay = FiveHourDisplay.ZERO;

    public int getSecondsDisplayState() {
        return secondsDisplay.getDisplayState();
    }

    public void setSecondsDisplay(SecondsDisplay secondsDisplay) {
        this.secondsDisplay = secondsDisplay;
    }

    public int get5HourDisplayState() {
        return fiveHourDisplay.getDisplayState();
    }

    public void set5HourDisplay(FiveHourDisplay fiveHourDisplay) {
        this.fiveHourDisplay = fiveHourDisplay;
    }

    public int get1HourDisplayState() {
        return 0;
    }

    public int get5MinuteDisplayState() {
        return 0;
    }

    public int get1MinuteDisplayState() {
        return 0;
    }

}
