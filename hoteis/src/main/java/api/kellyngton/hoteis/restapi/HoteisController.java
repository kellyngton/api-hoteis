package api.kellyngton.hoteis.restapi;

import api.kellyngton.hoteis.exception.HotelsNotFindException;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;
import api.kellyngton.hoteis.service.GetHoteisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/hoteis")
public class HoteisController {

    private final GetHoteisService buscarHoteisService;

    @GetMapping(path = "/{codigoCidade}")
    public List<HoteisResponseApi> hoteis(@Min(value = 0, message = "Código da cidade não pode ser negativo")
                                          @PathVariable(value = "codigoCidade") long codigoCidade) throws HotelsNotFindException {
            return buscarHoteisService.buscarPorId(codigoCidade);
    }
}
