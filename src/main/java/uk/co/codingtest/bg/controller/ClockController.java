package uk.co.codingtest.bg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.exception.InvalidParameterException;
import uk.co.codingtest.bg.service.ClockService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ClockController {

    private final ClockService clockService;

    @Autowired
    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @RequestMapping(value = "/display-time")
    public ClockDisplay displayTime(@RequestParam("time")  String time) throws InvalidParameterException {
        return clockService.getDisplay(time);
    }

}
