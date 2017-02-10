package uk.co.codingtest.bg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.codingtest.bg.bean.ClockDisplay;
import uk.co.codingtest.bg.service.ClockService;

@RestController
public class ClockController {

    private final ClockService clockService;

    @Autowired
    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @RequestMapping(value = "/display-time")
    @ResponseBody
    public ClockDisplay displayTime(@RequestParam("time")  String time) {
        return clockService.getDisplay(time);
    }
}
