package api.kellyngton.hoteis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "Hoteis",
                version = "1.0",
                description = "API REST que busca hoteis pelo código da cidade.",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Kellyngton luiz",
                        email = "kelldias895@gmail.com",
                        url = "https://github.com/kellyngton"
                    )

        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server."
                ),
                //TODO: Adicionar ao servidor de produção
                @Server(
                        url = "https://hoteis-kellyngton.herokuapp.com",
                        description = "Heroku server."
                ),

        }
)
public class HoteisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoteisApplication.class, args);
    }

}
