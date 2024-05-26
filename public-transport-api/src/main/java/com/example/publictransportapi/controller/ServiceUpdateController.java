package com.example.publictransportapi.controller;

import com.example.publictransportapi.entities.ServiceUpdate;
import com.example.publictransportapi.service.ServiceUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-updates")
public class ServiceUpdateController {
    @Autowired
    private ServiceUpdateService serviceUpdateService;

    @GetMapping
    public List<ServiceUpdate> getAllServiceUpdates() {
        return serviceUpdateService.findAll();
    }

    @PostMapping
    public ServiceUpdate createServiceUpdate(@RequestBody ServiceUpdate serviceUpdate) {
        return serviceUpdateService.save(serviceUpdate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceUpdate> getServiceUpdateById(@PathVariable Long id) {
        ServiceUpdate serviceUpdate = serviceUpdateService.findByIdOrThrow(id);
        return ResponseEntity.ok(serviceUpdate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceUpdate> updateServiceUpdate(@PathVariable Long id, @RequestBody ServiceUpdate serviceUpdateDetails) {
        ServiceUpdate serviceUpdate = serviceUpdateService.findByIdOrThrow(id);
        serviceUpdate.setMessage(serviceUpdateDetails.getMessage());
        serviceUpdate.setDate(serviceUpdateDetails.getDate());
        ServiceUpdate updatedServiceUpdate = serviceUpdateService.save(serviceUpdate);
        return ResponseEntity.ok(updatedServiceUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceUpdate(@PathVariable Long id) {
        serviceUpdateService.findByIdOrThrow(id);
        serviceUpdateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
