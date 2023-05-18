package sopt.mysoptin.server.exception.model;

import lombok.Getter;
import sopt.mysoptin.server.exception.Success;

@Getter
public class NoContentException extends RuntimeException{
    private final Success success;

    public NoContentException(Success success, String message) {
        super(message);
        this.success = success;
    }

    public int getHttpStatus() {
        return success.getHttpStatusCode();
    }
}
