package net.skillspire.fleet;

// POINT: one class answers for every controller: any IllegalArgumentException becomes 400 Bad Request
//        with its message. Only that exception: a bug in our code should still be a 500.
// ASK:   "Who made the mistake when minYear is -5: the client or our code? Which status says so?"

// LMS REST Controllers P10. Params and Path Variables P4.

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice     // * SPOT THE BUG: comment out this line, restart, GET /api/vehicles/search?minYear=-5
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadInput(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());     // 400
    }
}
