/*
package api.kellyngton.hoteis.target;

public class MocksHotels {

        public static void setupMockBooksResponse(WireMockServer mockService) throws IOException {
            mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/books"))
                    .willReturn(WireMock.aResponse()
                            .withStatus(HttpStatus.OK.value())
                            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                            .withBody(
                                    copyToString(
                                            BookMocks.class.getClassLoader().getResourceAsStream("payload/get-books-response.json"),
                                            defaultCharset()))));
        }

}
*/
