package com.Road_Tracking.controllers;

import com.Road_Tracking.entity.Route;
import com.Road_Tracking.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    private final  RouteService routeService;
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
    @GetMapping
    public List<Route> findAll() {
        return routeService.findAll();
    }

    @PostMapping
    public Route addRoute(@RequestBody Route route) {
        return routeService.save(route);
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.findById(id);
    }

    @DeleteMapping("/{id}")
   public String deleteById(@PathVariable Long id)
   {
        return routeService.deleteById(id);
   }


}
