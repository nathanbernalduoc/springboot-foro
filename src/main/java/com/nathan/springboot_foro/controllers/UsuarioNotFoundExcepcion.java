package com.nathan.springboot_foro.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundExcepcion extends RuntimeException {

    public UsuarioNotFoundExcepcion(String message) {
        super(message);
    }
}
