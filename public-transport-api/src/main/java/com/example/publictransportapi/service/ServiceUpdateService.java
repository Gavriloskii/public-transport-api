package com.example.publictransportapi.service;

import com.example.publictransportapi.entities.ServiceUpdate;
import com.example.publictransportapi.exception.ResourceNotFoundException;
import com.example.publictransportapi.repositories.ServiceUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUpdateService {
    @Autowired
    private ServiceUpdateRepository serviceUpdateRepository;

    public List<ServiceUpdate> findAll() {
        return serviceUpdateRepository.findAll();
    }

    public ServiceUpdate save(ServiceUpdate serviceUpdate) {
        return serviceUpdateRepository.save(serviceUpdate);
    }

    public Optional<ServiceUpdate> findById(Long id) {
        return serviceUpdateRepository.findById(id);
    }

    public ServiceUpdate findByIdOrThrow(Long id) {
        return serviceUpdateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Service update not found with id: " + id));
    }

    public void deleteById(Long id) {
        serviceUpdateRepository.deleteById(id);
    }
}
