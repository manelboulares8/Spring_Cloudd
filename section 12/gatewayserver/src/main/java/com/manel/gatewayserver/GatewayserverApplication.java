package com.manel.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }
    @Bean
    public RouteLocator MyRouteConfig(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/ins/**")
                        .uri("lb://INSTITUT-MS"))
                .route(p -> p
                        .path("/api/etudiants/**")
                        .filters( f -> f.circuitBreaker(config ->
                                config.setName("etudiantCircuitBreaker")
                                        .setFallbackUri("forward:/contactAdmin")))

                        .uri("lb://ETUDIANTS-MS"))
                .build();
    }
}
