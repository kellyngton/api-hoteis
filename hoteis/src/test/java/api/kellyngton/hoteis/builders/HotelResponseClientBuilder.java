package api.kellyngton.hoteis.builders;

import api.kellyngton.hoteis.client.response.HotelResponseClient;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelResponseClientBuilder {
    public static HotelResponseClient hotelResponseClient1L() {
        return  HotelResponseClient.builder()
                .id(10)
                .name("Hotel 1")
                .cityCode(1032)
                .cityName("São Paulo")
                .roons(RoomBuilder.room1L())
                .build();
    }

    public static HotelResponseClient hotelResponseClient2L() {
        return HotelResponseClient.builder()
                .id(19)
                .name("Hotel 2")
                .cityCode(1032)
                .cityName("São Paulo")
                .roons(RoomBuilder.room2L())
                .build();
    }

    public static HotelResponseClient hotelResponseClient3L() {
        return HotelResponseClient.builder()
                .id(12)
                .name("Hotel 3")
                .cityCode(1032)
                .cityName("São Paulo")
                .roons(RoomBuilder.room3L())
                .build();
    }

    public static Optional<List <HotelResponseClient>> hotelResponseClientList1L(){
        List<HotelResponseClient> hotelResponseClientList = new ArrayList<>();
        hotelResponseClientList.add(hotelResponseClient1L());
        hotelResponseClientList.add(hotelResponseClient2L());
        hotelResponseClientList.add(hotelResponseClient3L());
        return Optional.of(hotelResponseClientList);
    }

}
