package com.Road_Tracking.service;

import com.Road_Tracking.entity.Route;
import com.Road_Tracking.exception.NotFoundException;
import com.Road_Tracking.repository.RouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RouteServiceimpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceimpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Flux<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Mono<Route> save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Mono<Route> findById(Long id) {
        return routeRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new NotFoundException("Route Not Found With id: " + id, "ROUTE_NOT_FOUND")));
    }

    @Override
    public Mono<String> deleteById(Long id) {
        return routeRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new NotFoundException("Route Not Found With id: " + id, "ROUTE_NOT_FOUND")))
                .flatMap(route -> routeRepository.delete(route)
                        .thenReturn("✅ Route Deleted Successfully with id: " + id));
    }
}
