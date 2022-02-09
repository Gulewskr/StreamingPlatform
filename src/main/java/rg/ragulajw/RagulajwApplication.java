package rg.ragulajw;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RagulajwApplication {

    public static void main(String[] args) {
        SpringApplication.run(RagulajwApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("2") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Stream API").version(appVersion));
    }
}
