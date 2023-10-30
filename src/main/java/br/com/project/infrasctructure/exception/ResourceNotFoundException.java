package br.com.project.infrasctructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	@Serial
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(final String message) {
    	super(message);
    }
}
