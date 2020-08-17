package com.teksenz.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//@Profile("google")
//@Configuration
public class GoogleConfig {
    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/search")
//                        .filters(f->f.rewritePath("/search(?<segment>/?.*)","/${segment}"))
                        .uri("https://www.google.com")
                        .id("google"))
                .build();
    }
}
