package uk.co.codingtest.bg.enums;

import java.util.Arrays;
import java.util.Optional;

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

    public static FiveHourDisplay fromDisplayState(int i) {
        return Arrays.stream(FiveHourDisplay.values()).filter(e -> e.getDisplayState() == i).findAny().get();
    }
}
