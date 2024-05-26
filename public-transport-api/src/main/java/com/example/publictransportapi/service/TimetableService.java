package com.example.publictransportapi.service;

import com.example.publictransportapi.entities.Timetable;
import com.example.publictransportapi.exception.ResourceNotFoundException;
import com.example.publictransportapi.repositories.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    public Timetable save(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    public Optional<Timetable> findById(Long id) {
        return timetableRepository.findById(id);
    }

    public Timetable findByIdOrThrow(Long id) {
        return timetableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Timetable not found with id: " + id));
    }

    public void deleteById(Long id) {
        timetableRepository.deleteById(id);
    }
}
