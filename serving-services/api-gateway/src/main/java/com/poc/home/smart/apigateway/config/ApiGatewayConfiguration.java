package com.poc.home.smart.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/weather-serving-service/**")
                        .filters(f -> f.rewritePath(
                                "/weather-serving-service/(?<segment>.*)",
                                "/${segment}"))
                        .uri("lb:///weather-serving-service"))
                .build();
    }

}
