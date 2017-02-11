package uk.co.codingtest.bg.enums;

public enum FiveHourDisplay {
    ZERO(0),
    FIVE(1),
    TEN(2),
    FIFTEEN(3),
    TWENTY(4);

    private int displayState;

    private FiveHourDisplay(int displayState) {
        this.displayState = displayState;
    }

    public int getDisplayState() {
        return displayState;
    }
}
