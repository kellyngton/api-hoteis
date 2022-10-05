package api.kellyngton.hoteis.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {
    @JsonProperty("adult")
    @NumberFormat(style = NumberFormat.Style.CURRENCY,
            pattern = "#,##0.00")
    private double adult;
    @JsonProperty("child")
    @NumberFormat(style = NumberFormat.Style.CURRENCY,
            pattern = "#,##0.00")
    private double child;
}
