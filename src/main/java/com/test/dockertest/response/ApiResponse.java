package com.test.dockertest.response;

import com.test.dockertest.exception.WnbtRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * [공통] API Response 결과의 반환 값을 관리
 */
public final class ApiResponse<T> {

    private final Optional<T> t;

    private ApiResponse(T t) {
        this.t = Optional.ofNullable(t);
    }

    public static <T> ApiResponse of(T t) {
        return new ApiResponse(t);
    }
    public static <T> ApiResponse of() {
        return new ApiResponse(null);
    }

    public ResponseEntity<T> ok() {
        return t.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(()->ResponseEntity.noContent().build());
    }

    public ResponseEntity<T> ifPresentOrElse(HttpStatus exists, HttpStatus notExists) {
        return t.map(value -> new ResponseEntity<>(value, exists))
                .orElseGet(() -> new ResponseEntity<>(notExists));
    }

    public ResponseEntity<T> ifPresentOrElse(Object result) {
        return t.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> (ResponseEntity<T>) new ResponseEntity<>(result, HttpStatus.OK));
    }


}
