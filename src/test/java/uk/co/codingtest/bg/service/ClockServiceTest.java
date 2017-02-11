package uk.co.codingtest.bg.service;

import org.junit.Before;
import org.junit.Test;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;

import static org.junit.Assert.*;

public class ClockServiceTest {
    private ClockService underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new ClockService();
    }

    @Test
    public void itShouldReturnClockDisplayForValidTimeInput() throws InvalidParameterException {
        ClockDisplay actual = underTest.getDisplay("11:11:11");
        assertNotNull(actual);
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