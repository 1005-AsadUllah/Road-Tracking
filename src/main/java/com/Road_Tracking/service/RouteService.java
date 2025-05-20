package com.Road_Tracking.service;

import com.Road_Tracking.entity.Route;

import java.util.List;

public interface RouteService {

    List<Route> findAll();

    Route save(Route route);

    Route findById(Long id);

    String deleteById(Long id);
}
