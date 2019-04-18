package info.esuarez.springwebcustomertracker.controller;

import com.sun.tools.internal.ws.wsdl.document.http.HTTPConstants;
import info.esuarez.springwebcustomertracker.error.CustomerErrorResponse;
import info.esuarez.springwebcustomertracker.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(CustomerNotFoundException exc) {
        CustomerErrorResponse error = new CustomerErrorResponse();

        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(Exception exc) {
        CustomerErrorResponse error = new CustomerErrorResponse();

        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
