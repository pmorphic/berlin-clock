package uk.co.codingtest.bg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClockService {

    private final DisplayEngine displayEngine;

    @Autowired
    public ClockService(DisplayEngine displayEngine) {
        this.displayEngine = displayEngine;
    }

    public ClockDisplay getDisplay(String time) throws InvalidParameterException {
        validatePattern(time);
        String[] stringSplit = time.split(":");
        int hh24 = validateAndToInt(stringSplit[0], 23);
        int mi = validateAndToInt(stringSplit[1], 59);
        int ss = validateAndToInt(stringSplit[2], 59);

//        Could use builder pattern
        ClockDisplay clockDisplay = new ClockDisplay();
        clockDisplay.setSecondsDisplay(displayEngine.getSecondsDisplay(ss));
        clockDisplay.set5HourDisplay(displayEngine.get5HourDisplay(hh24));
        clockDisplay.set1HourDisplay(displayEngine.get1HourDisplay(hh24));
        clockDisplay.set5MinuteDisplay(displayEngine.get5MinuteDisplay(mi));
        clockDisplay.set1MinuteDisplay(displayEngine.get1MinuteDisplay(mi));
        return clockDisplay;
    }

    private void validatePattern(String time) throws InvalidParameterException {
        String regex = "^(\\d){1,2}:(\\d){1,2}:(\\d){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);
        if (!matcher.matches()) {
            throw new InvalidParameterException();
        }
    }

    private int validateAndToInt(String value, int maxValue) throws InvalidParameterException {
        int i = Integer.valueOf(value);
        if (i > maxValue) {
            throw new InvalidParameterException();
        }
        return i;
    }

}
