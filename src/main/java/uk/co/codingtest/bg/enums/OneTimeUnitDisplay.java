package uk.co.codingtest.bg.enums;

import java.util.Arrays;

public enum OneTimeUnitDisplay {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private int displayState;

    private OneTimeUnitDisplay(int displayState) {
        this.displayState = displayState;
    }

    public int getDisplayState() {
        return displayState;
    }

    public static OneTimeUnitDisplay fromDisplayState(int i) {
        return Arrays.stream(OneTimeUnitDisplay.values()).filter(e -> e.getDisplayState() == i).findAny().get();
    }
}
