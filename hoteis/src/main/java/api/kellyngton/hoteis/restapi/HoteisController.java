package api.kellyngton.hoteis.restapi;

import api.kellyngton.hoteis.exception.HotelsNotFindException;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;
import api.kellyngton.hoteis.service.GetHoteisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/hoteis")
public class HoteisController {

    private final GetHoteisService buscarHoteisService;

    @GetMapping(path = "/{codigoCidade}")
    public List<HoteisResponseApi> hoteis(@Valid @PathVariable(value = "codigoCidade") long codigoCidade) throws HotelsNotFindException {

            return buscarHoteisService.buscarPorId(codigoCidade);

    }
}
