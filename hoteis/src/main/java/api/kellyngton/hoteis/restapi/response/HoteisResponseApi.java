package api.kellyngton.hoteis.restapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoteisResponseApi {

    @JsonProperty("hotel")
    private String hotel;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("valorTotal")
    private double valorTotal;

}
