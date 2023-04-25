package dev.elma.gateway_service_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceSpringApplication.class, args);
    }
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return  builder.routes()
                .route(r->r.path("/customers/**").uri("http://localhost:8081/"))
                .route(r->r.path("/products/**").uri("http://localhost:8082/"))
                .build();

    }

}
