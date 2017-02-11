package uk.co.codingtest.bg.bean;

import uk.co.codingtest.bg.enums.SecondsDisplay;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClockDisplay that = (ClockDisplay) o;
        return secondsDisplay == that.secondsDisplay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondsDisplay);
    }
}
