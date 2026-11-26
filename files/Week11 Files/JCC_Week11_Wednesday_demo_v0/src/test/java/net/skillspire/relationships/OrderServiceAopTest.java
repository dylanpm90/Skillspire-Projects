package net.skillspire.relationships;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class OrderServiceAopTest {
    @Autowired
    private OrderService orders;

    @Test
    void adviceRunsOnlyForDirectMatchingProxyCall(CapturedOutput output) {
        assertThat(AopUtils.isAopProxy(orders)).isTrue();
        assertThat(orders.status()).isEqualTo("Order service ready");
        assertThat(orders.placeFromInside("Mouse")).isEqualTo("Order preview for Mouse");
        assertThat(output.getOut()).doesNotContain("Before: placeOrder");

        assertThat(orders.placeOrder("Keyboard")).isEqualTo("Order preview for Keyboard");
        assertThat(output.getOut().lines().filter("Before: placeOrder"::equals).count())
                .isEqualTo(1);
    }

    @Test
    void invalidProductStillReachesCaller(CapturedOutput output) {
        assertThatThrownBy(() -> orders.placeOrder(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product is required");
        assertThat(output.getOut()).contains("Before: placeOrder");
        assertThat(output.getOut()).doesNotContain("Returned:");
    }

    @Test
    void successfulCallLogsResultAfterEntry(CapturedOutput output) {
        assertThat(orders.placeOrder("Keyboard")).isEqualTo("Order preview for Keyboard");
        String trace = output.getOut();
        assertThat(trace).contains("Returned: Order preview for Keyboard");
        assertThat(trace.indexOf("Before: placeOrder"))
                .isLessThan(trace.indexOf("Returned: Order preview for Keyboard"));
        assertThat(trace).doesNotContain("Threw:");
    }

    @Test
    void failureIsLoggedAndPropagates(CapturedOutput output) {
        assertThatThrownBy(() -> orders.placeOrder(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product is required");
        String trace = output.getOut();
        assertThat(trace).contains("Threw: Product is required");
        assertThat(trace.indexOf("Before: placeOrder"))
                .isLessThan(trace.indexOf("Threw: Product is required"));
        assertThat(trace).doesNotContain("Returned:");
    }

    @Test
    void nonmatchingAndInternalCallsProduceNoLoggingAdvice(CapturedOutput output) {
        assertThat(orders.status()).isEqualTo("Order service ready");
        assertThat(orders.placeFromInside("Mouse")).isEqualTo("Order preview for Mouse");
        assertThatThrownBy(() -> orders.placeFromInside(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output.getOut()).doesNotContain("Before:", "Returned:", "Threw:");
    }
}
