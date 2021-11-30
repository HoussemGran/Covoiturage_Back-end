package com.startU.covoiturage.rejoindre_trip;


import com.startU.covoiturage.trip.TripRepository;
import com.startU.covoiturage.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/rejoindre_trip")
public class RejoindreTripController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    RejoindreTripService rejoindretripService;

    @PostMapping
    public ResponseEntity<RejoindreTrip> rejoindreTrip(@RequestBody RejoindreTrip rejoindreTrip){
        return this.rejoindretripService.rejoindreTrip(rejoindreTrip);
    }

}
