package com.nathan.springboot_foro.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ComentarioNotFoundExcepcion extends RuntimeException {

    public ComentarioNotFoundExcepcion(String message) {
        super(message);
    }
}
