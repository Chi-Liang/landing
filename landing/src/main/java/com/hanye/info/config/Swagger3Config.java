package com.hanye.info.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
@Profile({"dev"}) //http://localhost/landing/swagger-ui/index.html
public class Swagger3Config {
	
	@Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hanye.info.controller.rest"))
                .build();
    }

	private ApiInfo apiInfo() {
        Contact contact = new Contact("fundodo", "https://fundodo.com.tw", "747731461@qq.com");
        return new ApiInfo(
                "Spring Boot 集成 Swagger3 測試",
                "Spring Boot 集成 Swagger3 測試街口文檔",
                "v1.0",
                "https://cunyu1943.github.io",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
