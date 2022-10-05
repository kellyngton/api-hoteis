package api.kellyngton.hoteis.client;

import api.kellyngton.hoteis.client.response.HotelResponseClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
@FeignClient(value = "hotelsClient", url = "https://cvcbackendhotel.herokuapp.com/hotels/avail")
public interface HotelsClient {

    @GetMapping(value = "/{ID_da_Cidade}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Optional<List <HotelResponseClient>> getHotelsById(@PathVariable long ID_da_Cidade);

}
