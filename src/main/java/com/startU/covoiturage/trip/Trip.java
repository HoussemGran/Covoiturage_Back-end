package com.startU.covoiturage.trip;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_conducteur;
    private String source;
    private String destination;
    private int nb_place;
    private Date date;
    private String heure;

    public Trip() {
    }

    public Trip(int id, int id_conducteur, String source, String distination, int nb_place, Date date) {
        this.id = id;
        this.id_conducteur = id_conducteur;
        this.source = source;
        this.destination = distination;
        this.nb_place = nb_place;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getId_conducteur() {
        return id_conducteur;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getNb_place() {
        return nb_place;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_conducteur(int id_conducteur) {
        this.id_conducteur = id_conducteur;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String distination) {
        this.destination = distination;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
