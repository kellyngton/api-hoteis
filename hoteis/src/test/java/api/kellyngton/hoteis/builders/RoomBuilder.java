package api.kellyngton.hoteis.builders;

import api.kellyngton.hoteis.client.response.Room;

public class RoomBuilder {
    public static Room[] room1L() {
        return new Room[]{
                Room.builder()
                        .roomID(1)
                        .categoryName("Standard")
                        .price(PriceBuilder.price1L())
                        .build()
        };
    }

    public static Room[] room2L() {
        return new Room[]{
                Room.builder()
                        .roomID(4)
                        .categoryName("Standard")
                        .price(PriceBuilder.price2L())
                        .build()
        };
    }

    public static Room[] room3L() {
        return new Room[]{
                Room.builder()
                        .roomID(7)
                        .categoryName("Standard")
                        .price(PriceBuilder.price3L())
                        .build()
        };
    }
}
