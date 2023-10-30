package br.com.project.infrasctructure.exception;

import java.io.Serial;

public class ResourceSizeException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceSizeException(final String message) {
        super(message);
    }

}
