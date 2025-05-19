// package com.jiawa.train.gateway.config;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.cloud.gateway.filter.GatewayFilterChain;
// import org.springframework.cloud.gateway.filter.GlobalFilter;
// import org.springframework.core.Ordered;
// import org.springframework.stereotype.Component;
// import org.springframework.web.server.ServerWebExchange;
// import reactor.core.publisher.Mono;
//
// /**
//  * Author: 陈桂明
//  * Date: 2025/5/19 13:50
//  * Description: Test1Filter
//  */
// @Component
// public class Test2Filter implements GlobalFilter, Ordered {
//
//     private static final Logger LOG = LoggerFactory.getLogger(Test2Filter.class);
//
//     @Override
//     public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//         LOG.info("Test1Filter");
//         return chain.filter(exchange);
//     }
//
//     @Override
//     public int getOrder() {
//         return 0;
//     }
// }
