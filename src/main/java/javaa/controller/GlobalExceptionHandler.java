package javaa.controller;


import org.springframework.stereotype.Component;

import java.util.logging.ErrorManager;

@Component

public class GlobalExceptionHandler<ResponseEntity> {

    private ErrorManager log;
    private Object BAD_REQUEST;

    @ExceptionHandler(value = DivideByZeroException.class)
    public ResponseEntity handleDivideByZeroException(DivideByZeroException g, Object HttpStatus) {
        log.error("Exception handled: "+ g.getMessage(), g);
        ErrorResponse errorResponse = new ErrorResponse("DIVIDE_BY_ZERO_ERROR", g.getMessage());

        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }

    private class BAD_REQUEST {
    }
}
