package sopt.mysoptin.server.exception.model;

import lombok.Getter;
import sopt.mysoptin.server.exception.Error;

@Getter
public class NotFoundException extends RuntimeException{
    private final Error error;

    public NotFoundException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
