package com.example.dalelmasjed.Model;

public class Masjed  {

String Name ;
Double rating ;
Boolean womensec ;
Boolean Jumaah ;
Boolean Parking ;
Boolean Wodhow ;
int Capacity;
int Masjed_Id;


    public Masjed() {


    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getWomensec() {
        return womensec;
    }

    public void setWomensec(Boolean womensec) {
        this.womensec = womensec;
    }

    public Boolean getJumaah() {
        return Jumaah;
    }

    public void setJumaah(Boolean jumaah) {
        Jumaah = jumaah;
    }

    public Boolean getParking() {
        return Parking;
    }

    public void setParking(Boolean parking) {
        Parking = parking;
    }

    public Boolean getWodhow() {
        return Wodhow;
    }

    public void setWodhow(Boolean wodhow) {
        Wodhow = wodhow;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getMasjed_Id() {
        return Masjed_Id;
    }

    public void setMasjed_Id(int masjed_Id) {
        Masjed_Id = masjed_Id;
    }
}
