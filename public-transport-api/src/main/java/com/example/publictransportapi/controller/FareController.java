package com.example.publictransportapi.controller;

import com.example.publictransportapi.entities.Fare;
import com.example.publictransportapi.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fares")
public class FareController {
    @Autowired
    private FareService fareService;

    @GetMapping
    public List<Fare> getAllFares() {
        return fareService.findAll();
    }

    @PostMapping
    public Fare createFare(@RequestBody Fare fare) {
        return fareService.save(fare);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fare> getFareById(@PathVariable Long id) {
        Fare fare = fareService.findByIdOrThrow(id);
        return ResponseEntity.ok(fare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fare> updateFare(@PathVariable Long id, @RequestBody Fare fareDetails) {
        Fare fare = fareService.findByIdOrThrow(id);
        fare.setTransportMode(fareDetails.getTransportMode());
        fare.setPrice(fareDetails.getPrice());
        Fare updatedFare = fareService.save(fare);
        return ResponseEntity.ok(updatedFare);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFare(@PathVariable Long id) {
        fareService.findByIdOrThrow(id);
        fareService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
