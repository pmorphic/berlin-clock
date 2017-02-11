package uk.co.codingtest.bg.enums;

public enum SecondsDisplay {
    ON(1),
    OFF(0);

    private int value;

    private SecondsDisplay(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
