package uk.co.codingtest.bg.enums;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class FiveHourDisplayTest {

    @Test
    public void itShouldReturnEnumIfFound() {
        assertEquals(FiveHourDisplay.ZERO, FiveHourDisplay.fromDisplayState(0));
        assertEquals(FiveHourDisplay.FIVE, FiveHourDisplay.fromDisplayState(1));
        assertEquals(FiveHourDisplay.TEN, FiveHourDisplay.fromDisplayState(2));
        assertEquals(FiveHourDisplay.FIFTEEN, FiveHourDisplay.fromDisplayState(3));
        assertEquals(FiveHourDisplay.TWENTY, FiveHourDisplay.fromDisplayState(4));
    }

    @Test (expected = NoSuchElementException.class)
    public void itShouldThrowIfEnumNotFound() {
        FiveHourDisplay.fromDisplayState(23);
    }

}