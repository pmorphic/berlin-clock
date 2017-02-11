package uk.co.codingtest.bg.enums;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class OneTimeUnitDisplayTest {

    @Test
    public void itShouldReturnEnumIfFound() {
        assertEquals(OneTimeUnitDisplay.ZERO, OneTimeUnitDisplay.fromDisplayState(0));
        assertEquals(OneTimeUnitDisplay.ONE, OneTimeUnitDisplay.fromDisplayState(1));
        assertEquals(OneTimeUnitDisplay.TWO, OneTimeUnitDisplay.fromDisplayState(2));
        assertEquals(OneTimeUnitDisplay.THREE, OneTimeUnitDisplay.fromDisplayState(3));
        assertEquals(OneTimeUnitDisplay.FOUR, OneTimeUnitDisplay.fromDisplayState(4));
    }

    @Test (expected = NoSuchElementException.class)
    public void itShouldThrowIfEnumNotFound() {
        OneTimeUnitDisplay.fromDisplayState(23);
    }

}