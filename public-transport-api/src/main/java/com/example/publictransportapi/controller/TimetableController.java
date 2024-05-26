package com.example.publictransportapi.controller;

import com.example.publictransportapi.entities.Timetable;
import com.example.publictransportapi.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public List<Timetable> getAllTimetables() {
        return timetableService.findAll();
    }

    @PostMapping
    public Timetable createTimetable(@RequestBody Timetable timetable) {
        return timetableService.save(timetable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable Long id) {
        Timetable timetable = timetableService.findByIdOrThrow(id);
        return ResponseEntity.ok(timetable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable Long id, @RequestBody Timetable timetableDetails) {
        Timetable timetable = timetableService.findByIdOrThrow(id);
        timetable.setRoute(timetableDetails.getRoute());
        timetable.setDepartureTime(timetableDetails.getDepartureTime());
        timetable.setArrivalTime(timetableDetails.getArrivalTime());
        Timetable updatedTimetable = timetableService.save(timetable);
        return ResponseEntity.ok(updatedTimetable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
        timetableService.findByIdOrThrow(id);
        timetableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
