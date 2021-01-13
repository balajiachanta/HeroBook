package com.gc.heloapi;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class HeroExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound() {
        return "Hero does not exist";
    }
}
