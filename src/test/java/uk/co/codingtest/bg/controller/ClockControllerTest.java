package uk.co.codingtest.bg.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;
import uk.co.codingtest.bg.service.ClockService;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClockControllerTest {
    private ClockController underTest;
    @Mock
    private ClockService clockService;
    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Before
    public void setUp() throws Exception {
        underTest = new ClockController(clockService);
    }

    @Test
    public void itShouldUseTimePassedIn() throws Exception {
        String time = "00:00:01";
        ClockDisplay expected = new ClockDisplay();
        when(clockService.getDisplay(time)).thenReturn(expected);

        ClockDisplay actual = underTest.displayTime(time);

        assertEquals(actual, expected);
    }

    @Test
    public void itShouldUseCurrentTimeIfRequestParamEmpty() throws Exception {
        Calendar startTime = Calendar.getInstance();

        underTest.displayTime(null);

        verify(clockService).getDisplay(argumentCaptor.capture());

        Calendar endTime = Calendar.getInstance();
        String[] timeParts = argumentCaptor.getValue().split(":");
        Integer actualHour = Integer.valueOf(timeParts[0]);
        Integer actualMin = Integer.valueOf(timeParts[1]);

        assertTrue(actualHour.equals(startTime.get(Calendar.HOUR_OF_DAY)) || actualHour.equals(endTime.get(Calendar.HOUR_OF_DAY)));
        assertTrue(actualMin.equals(startTime.get(Calendar.MINUTE)) || actualMin.equals(endTime.get(Calendar.MINUTE)));
    }

}