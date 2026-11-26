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

    @AfterReturning(pointcut = "placeOrderCall()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("Returned: " + result);
    }

    @AfterThrowing(pointcut = "placeOrderCall()", throwing = "ex")
    public void logAfterThrowing(IllegalArgumentException ex) {
        System.out.println("Threw: " + ex.getMessage());
    }
}
