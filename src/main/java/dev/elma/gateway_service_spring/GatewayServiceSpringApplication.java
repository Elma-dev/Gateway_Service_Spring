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

    //Static Routes without Eureka
    /*
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return  builder.routes()
                .route(r->r.path("/customers/**").uri("http://localhost:8081/"))
                .route(r->r.path("/products/**").uri("http://localhost:8082/"))
                .build();

    }
     */

    //Static Routes with Eureka
    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();

    }

}
