package com.chrisgruber.nanourl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such nano url")
public class NanoUrlEntityNotFoundException extends RuntimeException {
}
