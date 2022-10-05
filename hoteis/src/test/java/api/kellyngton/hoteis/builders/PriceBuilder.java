package api.kellyngton.hoteis.builders;

import api.kellyngton.hoteis.client.response.Price;

public class PriceBuilder {
    public static Price price1L() {
        return Price.builder()
                .adult(1000.00)
                .child(65.80)
                .build();
    }

    public static Price price2L() {
        return Price.builder()
                .adult(1400.00)
                .child(78.69)
                .build();
    }

    public static Price price3L() {
        return Price.builder()
                .adult(1200.00)
                .child(98.37)
                .build();
    }
}
