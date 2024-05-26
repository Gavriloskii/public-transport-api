package com.example.publictransportapi.controller;

import com.example.publictransportapi.entities.Route;
import com.example.publictransportapi.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.findAll();
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.save(route);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.findByIdOrThrow(id);
        return ResponseEntity.ok(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route routeDetails) {
        Route route = routeService.findByIdOrThrow(id);
        route.setStartLocation(routeDetails.getStartLocation());
        route.setEndLocation(routeDetails.getEndLocation());
        Route updatedRoute = routeService.save(route);
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.findByIdOrThrow(id);
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
