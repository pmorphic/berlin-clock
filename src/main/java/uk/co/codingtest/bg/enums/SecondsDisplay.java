package uk.co.codingtest.bg.enums;

public enum SecondsDisplay {
    ON(1),
    OFF(0);

    private int displayState;

    private SecondsDisplay(int displayState) {
        this.displayState = displayState;
    }

    public int getDisplayState() {
        return displayState;
    }
}
