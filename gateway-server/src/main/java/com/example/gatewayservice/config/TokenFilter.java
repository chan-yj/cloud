package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(token == null || token.isEmpty()){
            System.out.println("token is empty.....");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
//        System.out.println("进来TokenFilter。。。");
//        ServerHttpRequest req = exchange.getRequest().mutate()
//                .header("from", "gateway").build();
//        return chain.filter(exchange.mutate().request(req.mutate().build()).build());
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
