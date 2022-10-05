package api.kellyngton.hoteis.builders;

import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;

import java.util.ArrayList;
import java.util.List;


public class HoteisResponseApiBuilder {

    //todo: criar mocks para testes
    public static HoteisResponseApi hoteisResponseApi1L() {
        return HoteisResponseApi.builder()
                .hotel("Hotel 1")
                .cidade("São Paulo")
                .valorTotal(1941.89)
                .build();
    }

    public static HoteisResponseApi hoteisResponseApi2L() {
        return HoteisResponseApi.builder()
                .hotel("Hotel 2")
                .cidade("São Paulo")
                .valorTotal(1783.53)
                .build();
    }

    public static HoteisResponseApi hoteisResponseApi3L() {
        return HoteisResponseApi.builder()
                .hotel("Hotel 3")
                .cidade("São Paulo")
                .valorTotal(1283.53)
                .build();
    }

    public static List<HoteisResponseApi> hoteisResponseApiList1L(){
        List<HoteisResponseApi> hoteisResponseApiList = new ArrayList<>();
        hoteisResponseApiList.add(hoteisResponseApi1L());
        hoteisResponseApiList.add(hoteisResponseApi2L());
        hoteisResponseApiList.add(hoteisResponseApi3L());
        return hoteisResponseApiList;
    }

}
