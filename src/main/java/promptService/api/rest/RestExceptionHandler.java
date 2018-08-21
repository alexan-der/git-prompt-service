package promptService.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import promptService.api.exception.ApiError;
import promptService.api.exception.DateFormatException;
import promptService.api.exception.IdMismatchException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ IdMismatchException.class, DateFormatException.class })
    public ResponseEntity<ApiError> handleBadRequestError(Exception e) {
        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST.value(), e!=null?e.getMessage():""), HttpStatus.BAD_REQUEST);
    }

}
