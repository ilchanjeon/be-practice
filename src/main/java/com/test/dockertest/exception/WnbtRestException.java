package com.test.dockertest.exception;

import com.test.dockertest.exception.code.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WnbtRestException extends RuntimeException {
    private String code;
    private ErrorCode errCode;

    public WnbtRestException(String message) {
        super(message);
    }

    public WnbtRestException(String code, String message) {
        super(message);
        this.code = code;
    }

    public WnbtRestException(ErrorCode errCode){
        super(errCode.getMessage());
        this.code = String.valueOf(errCode.getStatus());
        this.errCode = errCode;
    }

    public WnbtRestException(ErrorCode errCode, String customMessage) {
        super(customMessage);
        this.code = String.valueOf(errCode.getStatus());
        this.errCode = errCode;
    }

    public WnbtRestException(String message, Throwable cause){
        super(message, cause);
    }

}
