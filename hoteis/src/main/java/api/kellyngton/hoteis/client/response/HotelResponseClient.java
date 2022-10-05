package api.kellyngton.hoteis.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponseClient {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    private long cityCode;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("rooms")
    private Room[] roons;

}
