package com.example.publictransportapi.service;

import com.example.publictransportapi.entities.Fare;
import com.example.publictransportapi.exception.ResourceNotFoundException;
import com.example.publictransportapi.repositories.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FareService {
    @Autowired
    private FareRepository fareRepository;

    public List<Fare> findAll() {
        return fareRepository.findAll();
    }

    public Fare save(Fare fare) {
        return fareRepository.save(fare);
    }

    public Optional<Fare> findById(Long id) {
        return fareRepository.findById(id);
    }

    public Fare findByIdOrThrow(Long id) {
        return fareRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fare not found with id: " + id));
    }

    public void deleteById(Long id) {
        fareRepository.deleteById(id);
    }
}
