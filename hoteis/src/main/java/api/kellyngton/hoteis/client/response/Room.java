package api.kellyngton.hoteis.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Room {
    @JsonProperty("roomID")
    private long roomID;
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("price")
    private Price price;

}
