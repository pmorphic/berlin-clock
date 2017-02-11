package uk.co.codingtest.bg.service;

import org.springframework.stereotype.Service;
import uk.co.codingtest.bg.enums.SecondsDisplay;

@Service
public class DisplayEngine {
    public SecondsDisplay getSecondsDisplay(int seconds) {
        return SecondsDisplay.OFF;
    }
}
