package com.chrisgruber.nanourl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Persistence operation failed")
public class NanoUrlEntitySaveException extends RuntimeException {
}