package com.athomic.app.config;

import com.athomic.app.dto.response.ErrorResponse;
import com.athomic.app.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling different types of exceptions and returning appropriate error responses.
 * <p>
 * This class uses the {@link ControllerAdvice} annotation to handle exceptions thrown by controllers and return
 * meaningful error responses with appropriate HTTP status codes and messages.
 * </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles {@link NotFoundException} exceptions.
     * <p>
     * Returns a {@link ResponseEntity} with HTTP status 404 (Not Found) and an error response containing
     * the exception message.
     * </p>
     *
     * @param ex the {@link NotFoundException} exception
     * @return a {@link ResponseEntity} with an {@link ErrorResponse} and HTTP status 404
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        ErrorResponse response =
                new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles {@link IllegalArgumentException} exceptions.
     * <p>
     * Returns a {@link ResponseEntity} with HTTP status 400 (Bad Request) and an error response containing
     * the exception message.
     * </p>
     *
     * @param ex the {@link IllegalArgumentException} exception
     * @return a {@link ResponseEntity} with an {@link ErrorResponse} and HTTP status 400
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse response =
                new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all other exceptions.
     * <p>
     * Logs the exception and returns a {@link ResponseEntity} with HTTP status 500 (Internal Server Error)
     * and a generic error response.
     * </p>
     *
     * @param ex the {@link Exception} exception
     * @return a {@link ResponseEntity} with an {@link ErrorResponse} and HTTP status 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        LOGGER.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
        ErrorResponse response =
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
