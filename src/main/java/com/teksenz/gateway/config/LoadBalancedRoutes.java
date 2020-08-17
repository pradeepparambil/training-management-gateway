package com.teksenz.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@Configuration
public class LoadBalancedRoutes {
    @Bean
    public RouteLocator loadBalanced(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/api/v1/course*","/api/v1/course/*")
                        .uri("lb://course-service")
                        .id("course-service"))
                .route(r->r.path("/api/v1/student*","/api/v1/student/*",
                        "/api/v1/referee*","/api/v1/referee/*")
                        .uri("lb://student-service")
                        .id("student-service"))
                .build();
    }
}
