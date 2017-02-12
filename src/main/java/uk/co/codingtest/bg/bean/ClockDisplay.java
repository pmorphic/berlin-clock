package uk.co.codingtest.bg.bean;

import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.FiveMinuteDisplay;
import uk.co.codingtest.bg.enums.OneTimeUnitDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;

public class ClockDisplay {
    private SecondsDisplay secondsDisplay = SecondsDisplay.OFF;
    private FiveHourDisplay fiveHourDisplay = FiveHourDisplay.ZERO;
    private OneTimeUnitDisplay oneHourDisplay = OneTimeUnitDisplay.ZERO;
    private FiveMinuteDisplay fiveMinuteDisplay = FiveMinuteDisplay.ZERO;
    private OneTimeUnitDisplay oneMinuteDisplay = OneTimeUnitDisplay.ZERO;

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
        return oneHourDisplay.getDisplayState();
    }

    public void set1HourDisplay(OneTimeUnitDisplay oneHourDisplay) {
        this.oneHourDisplay = oneHourDisplay;
    }

    public int get5MinuteDisplayState() {
        return fiveMinuteDisplay.getDisplayState();
    }

    public void set5MinuteDisplay(FiveMinuteDisplay fiveMinuteDisplay) {
        this.fiveMinuteDisplay = fiveMinuteDisplay;
    }

    public int get1MinuteDisplayState() {
        return oneMinuteDisplay.getDisplayState();
    }

    public void set1MinuteDisplay(OneTimeUnitDisplay oneMinuteDisplay) {
        this.oneMinuteDisplay = oneMinuteDisplay;
    }

}
