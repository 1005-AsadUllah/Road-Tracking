package com.Road_Tracking.controllers;

import com.Road_Tracking.entity.Route;
import com.Road_Tracking.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public Flux<Route> findAll() {
        return routeService.findAll();
    }

    @PostMapping
    public Mono<Route> addRoute(@RequestBody Route route) {
        return routeService.save(route);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Route>> getRouteById(@PathVariable Long id) {
        return routeService.findById(id)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteById(@PathVariable Long id) {
        return routeService.deleteById(id)
                .map(msg -> ResponseEntity.ok().body(msg))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
}
