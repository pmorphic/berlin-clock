package uk.co.codingtest.bg.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;
import uk.co.codingtest.bg.service.ClockService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClockControllerTest {
    private ClockController underTest;
    @Mock
    private ClockService clockService;

    @Before
    public void setUp() throws Exception {
        underTest = new ClockController(clockService);
    }

    @Test
    public void itShouldUseValidTimePassedIn() throws Exception {
        String time = "00:00:01";
        ClockDisplay expected = new ClockDisplay();
        when(clockService.getDisplay(time)).thenReturn(expected);

        ClockDisplay actual = underTest.displayTime(time);

        assertEquals(actual, expected);
    }

    @Test
    public void itShouldThrowIfInvalidTimePassedIn() {
        String time = "abc";

        try {
            underTest.displayTime(time);
            fail("Should throw exception");
        } catch (InvalidParameterException e) {

        }

        verifyZeroInteractions(clockService);
    }

}