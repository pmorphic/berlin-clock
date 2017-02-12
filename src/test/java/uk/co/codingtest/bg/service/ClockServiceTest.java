package uk.co.codingtest.bg.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.enums.FiveHourDisplay;
import uk.co.codingtest.bg.enums.OneTimeUnitDisplay;
import uk.co.codingtest.bg.enums.SecondsDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClockServiceTest {
    private ClockService underTest;
    @Mock
    private DisplayEngine displayEngine;

    @Before
    public void setUp() throws Exception {
        underTest = new ClockService(displayEngine);
    }

    @Test
    public void itShouldReturnClockDisplayForValidTimeInput() throws InvalidParameterException {
        when(displayEngine.getSecondsDisplay(10)).thenReturn(SecondsDisplay.ON);
        when(displayEngine.get5HourDisplay(11)).thenReturn(FiveHourDisplay.TEN);
        when(displayEngine.get1HourDisplay(11)).thenReturn(OneTimeUnitDisplay.ONE);

        ClockDisplay actual = underTest.getDisplay("11:11:10");
        assertEquals(SecondsDisplay.ON.getDisplayState(), actual.getSecondsDisplayState());
        assertEquals(FiveHourDisplay.TEN.getDisplayState(), actual.get5HourDisplayState());
        assertEquals(OneTimeUnitDisplay.ONE.getDisplayState(), actual.get1HourDisplayState());
    }

    @Test (expected = InvalidParameterException.class)
    public void itShouldThrowForInvalidTime() throws InvalidParameterException {
        underTest.getDisplay("abc");
    }

    @Test (expected = InvalidParameterException.class)
    public void itShouldThrowForInvalidTimeFormat() throws InvalidParameterException {
        underTest.getDisplay("10:10:10.1000Z");
    }

    @Test (expected = InvalidParameterException.class)
    public void itShouldThrowForInvalidHour() throws InvalidParameterException {
        underTest.getDisplay("24:10:10");
    }

    @Test (expected = InvalidParameterException.class)
    public void itShouldThrowForInvalidMinute() throws InvalidParameterException {
        underTest.getDisplay("23:60:10");
    }

    @Test (expected = InvalidParameterException.class)
    public void itShouldThrowForInvalidSecond() throws InvalidParameterException {
        underTest.getDisplay("02:10:60");
    }

}