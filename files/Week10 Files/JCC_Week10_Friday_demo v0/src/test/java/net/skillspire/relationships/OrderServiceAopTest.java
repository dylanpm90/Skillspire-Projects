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
}
