package uk.co.codingtest.bg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Time parameter must of format HH24:MI:SS")
public class InvalidParameterException extends Exception{

}
