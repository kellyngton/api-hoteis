package api.kellyngton.hoteis.controller;

import api.kellyngton.hoteis.builders.HoteisResponseApiBuilder;
import api.kellyngton.hoteis.restapi.HoteisController;
import api.kellyngton.hoteis.restapi.response.HoteisResponseApi;
import api.kellyngton.hoteis.service.GetHoteisServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HoteisController.class)
@ActiveProfiles("test")
public class HoteisControllerTest {
    private final String url = "/api/v1/hoteis";

    @Autowired
    private HoteisController hoteisController;

    private MockMvc mockMvc;

    @MockBean
    private GetHoteisServiceImpl getHoteisService;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(hoteisController).build();
        }

        @Test
        @DisplayName("Deve retornar uma lista de hoteis")
        void buscarHoteisQuandoCodigoCidadeExistenteTest() throws Exception {
            //Arrange
            when(getHoteisService.buscarPorId(1032)).thenReturn(HoteisResponseApiBuilder.hoteisResponseApiList1L());

            //Act
            mockMvc.perform(MockMvcRequestBuilders.get(url + "/1032").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andExpect(jsonPath("$[1].cidade", is("São Paulo")))
                    .andExpect(jsonPath("$[1].hotel", is("Hotel 2")))
                    .andExpect(jsonPath("$[1].valorTotal", is(1783.53)))
                    .andExpect(jsonPath("$[0].cidade", is("São Paulo")))
                    .andExpect(jsonPath("$[0].hotel", is("Hotel 1")))
                    .andExpect(jsonPath("$[0].valorTotal", is(1941.89)));
        }

        @Test
        @DisplayName("Deve lançar uma exceção quando não encontrar hoteis")
        void buscarHoteisQuandoCodigoCidadeInexistenteTest() throws Exception {     //TODO: verificar se é o melhor jeito de fazer, concertar o teste.
            //Arrange
            List<HoteisResponseApi> hoteisResponseApiList = new ArrayList<>();
            BeanUtils.copyProperties(HoteisResponseApiBuilder.hoteisResponseApiList1L(),hoteisResponseApiList);
            when(getHoteisService.buscarPorId(0)).thenReturn(hoteisResponseApiList);

            //Act
            ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url + "/0").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            //assert
            verify(hoteisController,times(1)).hoteis(0);

        }
}
