package uk.co.codingtest.bg.bean;

import uk.co.codingtest.bg.enums.SecondsDisplay;

public class ClockDisplay {
    private SecondsDisplay secondsDisplay = SecondsDisplay.OFF;

    public int getSeconds() {
        return secondsDisplay.getValue();
    }

    public void setSecondsDisplay(SecondsDisplay secondsDisplay) {
        this.secondsDisplay = secondsDisplay;
    }
}
