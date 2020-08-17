package com.teksenz.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {
    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/api/v1/course*","/api/v1/course/*")
                        .uri("http://localhost:8080")
                        .id("course-service"))
                .build();
    }
}
