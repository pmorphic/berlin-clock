package uk.co.codingtest.bg.bean;

import uk.co.codingtest.bg.enums.SecondsDisplay;

public class ClockDisplay {
    private SecondsDisplay secondsDisplay = SecondsDisplay.OFF;

    public int getSecondsDisplayState() {
        return secondsDisplay.getDisplayState();
    }

    public void setSecondsDisplay(SecondsDisplay secondsDisplay) {
        this.secondsDisplay = secondsDisplay;
    }

    public int get5HourDisplayState() {
        return 0;
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
