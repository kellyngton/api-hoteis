package api.kellyngton.hoteis.service;

import api.kellyngton.hoteis.exception.HotelsNotFindException;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;

import java.util.List;

@FunctionalInterface
public interface GetHoteisService {
   List<HoteisResponseApi> buscarPorId(long codigoCidade) throws HotelsNotFindException;
}
