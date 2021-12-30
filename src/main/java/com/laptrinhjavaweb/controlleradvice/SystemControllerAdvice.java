package com.laptrinhjavaweb.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SystemControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView modelAndView = new ModelAndView("web/exception/index");
        modelAndView.addObject("ex",e.getMessage());
        e.printStackTrace();
        return modelAndView;
    }
}
