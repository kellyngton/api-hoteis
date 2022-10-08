package api.kellyngton.hoteis.client.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelRequest {
    @NotBlank(message = "O id não pode ser nulo.")
    @Min(value = 0, message = "O id não pode ser negativo.")
    private long id;
}
