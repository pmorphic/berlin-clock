package uk.co.codingtest.bg.enums;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class FiveMinuteDisplayTest {

    @Test
    public void itShouldReturnEnumIfFound() {
        assertEquals(FiveMinuteDisplay.ZERO, FiveMinuteDisplay.fromDisplayState(0));
        assertEquals(FiveMinuteDisplay.FIVE, FiveMinuteDisplay.fromDisplayState(1));
        assertEquals(FiveMinuteDisplay.TEN, FiveMinuteDisplay.fromDisplayState(2));
        assertEquals(FiveMinuteDisplay.FIFTEEN, FiveMinuteDisplay.fromDisplayState(3));
        assertEquals(FiveMinuteDisplay.TWENTY, FiveMinuteDisplay.fromDisplayState(4));
    }

    @Test (expected = NoSuchElementException.class)
    public void itShouldThrowIfEnumNotFound() {
        FiveMinuteDisplay.fromDisplayState(23);
    }

}