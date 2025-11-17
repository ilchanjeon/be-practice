package com.test.dockertest.domain.controller;

import com.test.dockertest.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "test-controller", description = "test controller api 엔드포인트")
@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/test")
    @Operation(summary = "test api", description = "test 호출 string 'test data' 반환")
    public ResponseEntity<?> Test() {
        System.out.println("Hi");
        return ApiResponse.of("TEST DATA").ifPresentOrElse(HttpStatus.OK, HttpStatus.NOT_FOUND);
    }
}
