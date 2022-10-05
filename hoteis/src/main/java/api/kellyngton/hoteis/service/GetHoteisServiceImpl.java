package api.kellyngton.hoteis.service;

import api.kellyngton.hoteis.client.HotelsClient;
import api.kellyngton.hoteis.client.response.HotelResponseClient;
import api.kellyngton.hoteis.exception.HotelsNotFindException;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetHoteisServiceImpl implements GetHoteisService {

    private final HotelsClient hotelsClient;

    @Override
    public List<HoteisResponseApi> buscarPorId(long codigoCidade) throws HotelsNotFindException { //TODO buildar a HotelResponseClient -> HoteisResponseApi

            Optional<List<HotelResponseClient>> hotelResponseClient = hotelsClient.getHotelsById(codigoCidade);
            var hoteisResponseApi = new ArrayList<HoteisResponseApi>();

            if (hotelResponseClient.isPresent()) {
                hotelResponseClient.get().forEach(hotelResponseClient1 -> {
                    var hoteisResponseApi1 = new HoteisResponseApi();
                    hoteisResponseApi1 = HoteisResponseApi.builder()
                            .cidade(hotelResponseClient1.getCityName())
                            .hotel(hotelResponseClient1.getName())
                            .valorTotal(
                                    //TODO:fixando o resultado em duas casas decimais
                                    //TODO: regra de negócio valortotal = (2 * adult) + (1 * child)
                                    //TODO: considerei apenas o primeiro ROOM de cada hotel como no exemplo da task
                                    Math.round((2 * Arrays.stream(hotelResponseClient1.getRoons()).findFirst().get().getPrice().getAdult() +
                                            Arrays.stream(hotelResponseClient1.getRoons()).findFirst().get().getPrice().getChild()) * 100.0) / 100.0
                            )
                            .build();
                    BeanUtils.copyProperties(hotelResponseClient1, hoteisResponseApi1);
                    hoteisResponseApi.add(hoteisResponseApi1);
                });
                return hoteisResponseApi;
            }

            throw new HotelsNotFindException(codigoCidade, HoteisResponseApi.class.getSimpleName());
    }
}

