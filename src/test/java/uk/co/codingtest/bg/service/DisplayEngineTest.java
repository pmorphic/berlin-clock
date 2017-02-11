package uk.co.codingtest.bg.service;

import org.junit.Before;
import org.junit.Test;
import uk.co.codingtest.bg.enums.SecondsDisplay;

import static org.junit.Assert.*;

public class DisplayEngineTest {
    private DisplayEngine underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new DisplayEngine();
    }

    @Test
    public void itShouldReturnONForEvenSeconds() {
        assertEquals(SecondsDisplay.ON, underTest.getSecondsDisplay(0));
        assertEquals(SecondsDisplay.ON, underTest.getSecondsDisplay(12));
        assertEquals(SecondsDisplay.ON, underTest.getSecondsDisplay(26));
        assertEquals(SecondsDisplay.ON, underTest.getSecondsDisplay(58));
    }

    @Test
    public void itShouldReturnOFFForOddSeconds() {
        assertEquals(SecondsDisplay.OFF, underTest.getSecondsDisplay(1));
        assertEquals(SecondsDisplay.OFF, underTest.getSecondsDisplay(13));
        assertEquals(SecondsDisplay.OFF, underTest.getSecondsDisplay(25));
        assertEquals(SecondsDisplay.OFF, underTest.getSecondsDisplay(59));
    }

}