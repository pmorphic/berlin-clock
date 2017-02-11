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

}