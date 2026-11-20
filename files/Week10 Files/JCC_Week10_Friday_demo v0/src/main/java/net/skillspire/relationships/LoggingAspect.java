package net.skillspire.relationships;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* net.skillspire.relationships.OrderService.placeOrder(..))")
    private void placeOrderCall() {
    }

    @Before("placeOrderCall()")
    public void logBefore() {
        System.out.println("Before: placeOrder");
    }

    // TODO: Add @AfterReturning with pointcut = "placeOrderCall()" and returning = "result".
    @AfterReturning(pointcut = "placeOrderCall()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Returned: " + result);
    }
    // Print "Returned: " followed by the result. Keep this aspect a Spring bean.

    // TODO: Add @AfterThrowing with pointcut = "placeOrderCall()" and throwing = "ex".


    // Accept IllegalArgumentException ex and print "Threw: " followed by ex.getMessage().
    // Observe the exception; do not catch it or change the service's return value.
}
