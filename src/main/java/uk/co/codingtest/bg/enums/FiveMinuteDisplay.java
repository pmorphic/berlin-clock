package uk.co.codingtest.bg.enums;

import java.util.Arrays;

public enum FiveMinuteDisplay {
    ZERO(0),
    FIVE(1),
    TEN(2),
    FIFTEEN(3),
    TWENTY(4),
    TWENTY_FIVE(5),
    THIRTY(6),
    THIRTY_FIVE(7),
    FORTY(8),
    FORTY_FIVE(9),
    FIFTY(10),
    FIFTY_FIVE(11);

    private int displayState;

    private FiveMinuteDisplay(int displayState) {
        this.displayState = displayState;
    }

    public int getDisplayState() {
        return displayState;
    }

    public static FiveMinuteDisplay fromDisplayState(int i) {
        return Arrays.stream(FiveMinuteDisplay.values()).filter(e -> e.getDisplayState() == i).findAny().get();
    }
}
