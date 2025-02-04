package com.warehousepro.warehousepro_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Swagger documentation.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Customizes the Swagger API documentation.
     *
     * @return OpenAPI instance with project details.
     */
    @Bean
    public OpenAPI warehouseProOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WarehousePro API")
                        .description("API documentation for WarehousePro, a stock management platform.")
                        .version("1.0"));
    }
}
