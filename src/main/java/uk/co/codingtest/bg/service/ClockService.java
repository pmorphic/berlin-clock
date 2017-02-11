package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClockService {

    public ClockDisplay getDisplay(String time) throws InvalidParameterException {
        validatePattern(time);
        String[] stringSplit = time.split(":");
        int hh24 = validateAndToInt(stringSplit[0], 23);
        int mi = validateAndToInt(stringSplit[1], 59);
        int ss = validateAndToInt(stringSplit[2], 59);

        return new ClockDisplay();
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
