package com.Road_Tracking.service;

import com.Road_Tracking.entity.Route;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RouteService {
    Flux<Route> findAll();
    Mono<Route> save(Route route);
    Mono<Route> findById(Long id);
    Mono<String> deleteById(Long id);
}

