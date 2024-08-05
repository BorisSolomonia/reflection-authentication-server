//package com.boris.authentication_server.config;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CorsHeaderFilter implements WebFilter {
//
//    private static final String ALLOWED_ORIGIN = "http://localhost:3100";
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//
//        // Convert response headers to writable headers
//        HttpHeaders headers = HttpHeaders.writableHttpHeaders(response.getHeaders());
//
//        // If preflight request, set CORS headers and return OK
//        if (request.getMethod() == HttpMethod.OPTIONS) {
//            setCorsHeaders(headers);
//            response.setStatusCode(HttpStatus.OK);
//            return Mono.empty();
//        }
//
//        // For other requests, set headers only if they are not already present
//        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//            if (!headers.containsKey(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN)) {
//                setCorsHeaders(headers);
//            } else {
//                // If headers already contain allowed origin, ensure it is not duplicated
//                if (headers.get(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN).contains(ALLOWED_ORIGIN)) {
//                    headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ALLOWED_ORIGIN);
//                    System.out.println("fouuuuuur");
//                    headers.get(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN).stream().forEach(System.out::println);
//                }
//            }
//        }));
//    }
//
//    private void setCorsHeaders(HttpHeaders headers) {
//        headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ALLOWED_ORIGIN);
//        headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
//        headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Authorization, Content-Type");
//        headers.set(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization");
//        headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//    }
//}
