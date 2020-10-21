package com.hades.webflux.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WebFluxController {

    @GetMapping("/flux")
    public Mono<String> getResult(ServerHttpRequest request) {
        return Mono.defer(() -> Mono.just("Result is ready!"))
                .delaySubscription(Duration.ofMillis(500));
    }
}
