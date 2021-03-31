package model;

import java.util.Date;

public class Billet {
    String id;
    String reservation;
    Float price;
    Date date;

    public Billet(String id, String reservation, Float price, Date date ){
        this.id = id;
        this.reservation = reservation;
        this.price = price;
        this.date = date;

    }
}
