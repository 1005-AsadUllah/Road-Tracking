package com.Road_Tracking.repository;

import com.Road_Tracking.entity.Route;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface RouteRepository extends ReactiveCrudRepository<Route, Long> {
}