package com.partners.events.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Global exception handler for the application.
 * Handles validation errors and custom exceptions, providing appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation errors for method arguments.
     * Collects all field validation errors and returns them in a BAD_REQUEST response.
     *
     * @param ex the exception containing validation errors
     * @param headers HTTP headers
     * @param status HTTP status code
     * @param request the current web request
     * @return a ResponseEntity containing validation error messages
     */
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String validationMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, validationMsg);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all uncaught exceptions.
     * Returns a NOT_FOUND response with error details.
     *
     * @param exception the thrown exception
     * @param request the current web request
     * @return a ResponseEntity containing error details
     */
    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllException(Exception exception, WebRequest request) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setApiPath(request.getDescription(false));
        dto.setErrorCode(HttpStatus.NOT_FOUND);
        dto.setErrorMessage(exception.getMessage());
        dto.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);

    }

    /**
     * Handles PolicyNotFoundException.
     * Returns a NOT_FOUND response with error details when a policy is not found.
     *
     * @param exception the thrown PolicyNotFoundException
     * @param request the current web request
     * @return a ResponseEntity containing error details
     */
    @ExceptionHandler(exception = PolicyNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> policyNotFindWithGivenPolicyId(PolicyNotFoundException exception,
            WebRequest request) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setApiPath(request.getDescription(false));
        dto.setErrorCode(HttpStatus.NOT_FOUND);
        dto.setErrorMessage(exception.getMessage());
        dto.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);

    }

    /**
     * Handles ClientNotFoundException.
     * Returns a NOT_FOUND response with error details when a client is not found.
     *
     * @param exception the thrown ClientNotFoundException
     * @param request the current web request
     * @return a ResponseEntity containing error details
     */
    @ExceptionHandler(exception = ClientNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> clientNotFindWithGivenPolicyId(ClientNotFoundException exception,
            WebRequest request) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setApiPath(request.getDescription(false));
        dto.setErrorCode(HttpStatus.NOT_FOUND);
        dto.setErrorMessage(exception.getMessage());
        dto.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);

    }

}