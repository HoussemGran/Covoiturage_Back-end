package com.startU.covoiturage.rejoindre_trip;


import com.startU.covoiturage.trip.Trip;
import com.startU.covoiturage.user.User;

import javax.persistence.*;

@Entity
@Table(name = "rejoindre_trip")
public class RejoindreTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_trip" , referencedColumnName = "id" )
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "id_user" , referencedColumnName = "id")
    private User user;


    public RejoindreTrip(int id, Trip trip, User user) {
        this.id = id;
        this.trip = trip;
        this.user = user;
    }

    public RejoindreTrip() {
    }

    public int getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RejoindreTrip{" +
                "id=" + id +
                ", trip=" + trip.getId() +
                ", user=" + user.getId() +
                '}';
    }
}
