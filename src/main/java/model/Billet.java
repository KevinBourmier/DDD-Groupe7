package model;

import java.util.ArrayList;
import java.util.Date;

public class Billet {
    private final String id;
    private final String reservation;
    private final Double price;
    private final String date;
    private final ArrayList<Billet> billets = new ArrayList<>();

    public Billet(String id, String reservation, Double price, String date ){
        this.id = id;
        this.reservation = reservation;
        this.price = price;
        this.date = date;

    }


    public void ajouterBillets(Billet billet){
        this.billets.add(billet);
    }

    public ArrayList<Billet> rechercher(){
        return billets;
    }
}
