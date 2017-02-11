package uk.co.codingtest.bg.bean;

import org.junit.Before;
import org.junit.Test;
import uk.co.codingtest.bg.enums.SecondsDisplay;

import static org.junit.Assert.*;

public class ClockDisplayTest {

    private ClockDisplay underTest;

    @Before
    public void setup() {
        this.underTest = new ClockDisplay();
    }

    @Test
    public void itShouldReturnCorrectSecondsValue() {
        underTest.setSecondsDisplay(SecondsDisplay.OFF);
        assertEquals(0, underTest.getSeconds());

        underTest.setSecondsDisplay(SecondsDisplay.ON);
        assertEquals(1, underTest.getSeconds());
    }

}