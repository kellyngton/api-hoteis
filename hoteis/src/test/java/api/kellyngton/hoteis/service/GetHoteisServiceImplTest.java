package api.kellyngton.hoteis.service;

import api.kellyngton.hoteis.builders.HotelResponseClientBuilder;
import api.kellyngton.hoteis.client.HotelsClient;
import api.kellyngton.hoteis.exception.HotelsNotFindException;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GetHoteisServiceImplTest {

    private GetHoteisServiceImpl getHoteisService;


    @Mock
    private HotelsClient hotelsClient;

    @BeforeEach
    void setUp() {
        this.getHoteisService = new GetHoteisServiceImpl(hotelsClient);
    }

    @Test
    @DisplayName("Responde uma lista de hoteis, quando codigoCidade válido")
    void buscarQuandoIdExistenteTest() throws Exception {
        //Arrange
        when(hotelsClient.getHotelsById(1032))
                .thenReturn(HotelResponseClientBuilder.hotelResponseClientList1L());
        //Act
        List<HoteisResponseApi> hoteisResponseApiList = getHoteisService.buscarPorId(1032);

        //Assert

        assertThat("São Paulo", is(hoteisResponseApiList.get(0).getCidade()));
        assertThat("São Paulo", is(hoteisResponseApiList.get(1).getCidade()));
        assertThat("São Paulo", is(hoteisResponseApiList.get(2).getCidade()));

        //TODO: valorTotal= (2 * adult) + (1 * child)
        assertThat(hoteisResponseApiList.get(0).getValorTotal(), is(2065.80));
        assertThat(hoteisResponseApiList.get(1).getValorTotal(), is(2878.69));
        assertThat(hoteisResponseApiList.get(2).getValorTotal(), is(2498.37));

    }

    @Test
    @DisplayName("Responde uma exceção, quando codigoCidade inválido")
    void buscarQuandoCodigoCidadeInexistenteTest() throws Exception {
        //Arrange
        when(hotelsClient.getHotelsById(anyLong())).thenReturn(Optional.empty());

        //Assert
        assertThrows(HotelsNotFindException.class, () -> getHoteisService.buscarPorId(1872));

    }
}
