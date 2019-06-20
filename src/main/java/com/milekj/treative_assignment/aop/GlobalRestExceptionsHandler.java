package com.milekj.treative_assignment.aop;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalRestExceptionsHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        JsonErrorResponse errorResponse = new JsonErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Request JSON is malformed");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private class JsonErrorResponse {
        private final LocalDateTime timestamp;
        private final int status;
        private final String message;

        public JsonErrorResponse(int status, String message) {
            this.timestamp = LocalDateTime.now();
            this.status = status;
            this.message = message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

    }
}
