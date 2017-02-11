package uk.co.codingtest.bg.bean;

import org.junit.Before;
import org.junit.Test;
import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;

import static org.junit.Assert.*;

public class ClockDisplayTest {

    private ClockDisplay underTest;

    @Before
    public void setup() {
        this.underTest = new ClockDisplay();
    }

    @Test
    public void itShouldInitializeAllAttributesToZero() {
        assertEquals(0, underTest.getSecondsDisplayState());
        assertEquals(0, underTest.get5HourDisplayState());
        assertEquals(0, underTest.get1HourDisplayState());
        assertEquals(0, underTest.get5MinuteDisplayState());
        assertEquals(0, underTest.get1MinuteDisplayState());
    }

    @Test
    public void itShouldReturnCorrectSecondsValue() {
        underTest.setSecondsDisplay(SecondsDisplay.OFF);
        assertEquals(0, underTest.getSecondsDisplayState());

        underTest.setSecondsDisplay(SecondsDisplay.ON);
        assertEquals(1, underTest.getSecondsDisplayState());
    }

    @Test
    public void itShouldReturnCorrect5HourValue() {
        underTest.set5HourDisplay(FiveHourDisplay.FIFTEEN);
        assertEquals(3, underTest.get5HourDisplayState());

        underTest.set5HourDisplay(FiveHourDisplay.FIVE);
        assertEquals(1, underTest.get5HourDisplayState());
    }

}