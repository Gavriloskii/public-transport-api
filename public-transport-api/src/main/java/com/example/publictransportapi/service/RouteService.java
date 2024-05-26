package com.example.publictransportapi.service;

import com.example.publictransportapi.entities.Route;
import com.example.publictransportapi.exception.ResourceNotFoundException;
import com.example.publictransportapi.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    public Route save(Route route) {
        return routeRepository.save(route);
    }

    public Optional<Route> findById(Long id) {
        return routeRepository.findById(id);
    }

    public Route findByIdOrThrow(Long id) {
        return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    public void deleteById(Long id) {
        routeRepository.deleteById(id);
    }
}
