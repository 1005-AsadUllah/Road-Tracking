package com.Road_Tracking.service;

import com.Road_Tracking.entity.Route;
import com.Road_Tracking.exception.NotFoundException;
import com.Road_Tracking.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceimpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceimpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }

//    @Override
//    public Route findById(Long id) {
//        return routeRepository.findById(id).orElseThrow(() -> new NotFoundException("Route not found with id: " ,"id"));
//    }
    @Override
    public Route findById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Route not found with id: " + id, "Route not found"));
    }

//    @Override
//    public String deleteById(Long id) {
//        Route route = routeRepository.findById(id).orElseThrow(() -> new NotFoundException("Route not found with id: " , "id"));
//        routeRepository.delete(route);
//        return "Route deleted successfully by id: " + id;
//    }
    @Override
    public String deleteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Route not found with id: " + id, "Route not found"));
        routeRepository.delete(route);
        return "Route deleted successfully by id: " + id;
    }
}
