package com.startU.covoiturage.rejoindre_trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RejoindreTripService {

    @Autowired
    RejoindreTripRepository rejoindreTripRepository;

    public ResponseEntity<RejoindreTrip> rejoindreTrip(RejoindreTrip rejoindreTrip){
       return new ResponseEntity(rejoindreTripRepository.save(rejoindreTrip) , HttpStatus.OK);
    }


}
