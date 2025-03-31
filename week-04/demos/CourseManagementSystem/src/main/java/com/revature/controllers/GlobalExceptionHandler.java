package com.revature.controllers;

import com.revature.exceptions.ForbiddenActionException;
import com.revature.exceptions.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice // AOP (Aspect Oriented Programming)
public class GlobalExceptionHandler {

    /*
    Aspects are cross cutting concerns throughout your application (authentication, authorization, exception handling)
    AOP (Aspect Oriented Programming) is a programming paradigm where we focus on handling these concerns

    Advice
    Pointcut
    Before/After/Around
     */

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    public Map<String, String> unauthenticatedExceptionHandler(UnauthenticatedException e){
        return Map.of(
                "error", e.getMessage()
        );
    }

    @ExceptionHandler(ForbiddenActionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) // 403
    public Map<String, String> forbiddenExceptionHandler(ForbiddenActionException e){
        return Map.of(
                "error", e.getMessage()
        );
    }
}
