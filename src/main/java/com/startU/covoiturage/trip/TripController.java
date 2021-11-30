package com.startU.covoiturage.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/trip")
public class TripController {

    @Autowired
    TripService tripService;

    @GetMapping
    public ResponseEntity<Trip> getTrips(){
        return this.tripService.getTrips();
    }

    @PostMapping(path="/add")
    public ResponseEntity<Trip> registerNewStudent(@RequestBody Trip trip){
        return this.tripService.addTrip(trip);
    }


}
