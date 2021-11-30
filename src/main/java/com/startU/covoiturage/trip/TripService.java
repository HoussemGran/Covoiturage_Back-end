package com.startU.covoiturage.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public ResponseEntity<Trip> getTrips() {
        if (tripRepository.findAll().isEmpty()) {
            return new ResponseEntity("There is no trip", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tripRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Trip> addTrip(Trip trip) {
        return new ResponseEntity(tripRepository.save(trip),HttpStatus.OK);
    }

}
