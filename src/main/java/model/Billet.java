package model;

import use_case.assurance.RemboursementImpossible;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


public class Billet {
    private final String id;
    private final String reservation;
    private final Double price;
    private final LocalDate date;
    private final Boolean assurance;
    private final LocalDate dateAchat;
    private Boolean remboursement;

    public int getStatut() {
        return statut;
    }

    private int statut;
    public static final int DAYS_TO_SUBSTRACT = 30;

    public void setRemboursement(Boolean remboursement) {
        this.remboursement = remboursement;
    }

    public String getId() {
        return id;
    }

    public String getReservation() {
        return reservation;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getAssurance() {
        return assurance;
    }

    public Boolean getRemboursement() {
        return remboursement;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }


    public LocalDate getDate() {
        return date;
    }



    public Billet(String reservation, Double price, LocalDate date, Boolean assurance, LocalDate dateAchat){
        this.id = UUID.randomUUID().toString();
        this.reservation = reservation;
        this.price = price;
        this.date = date;
        this.assurance = assurance;
        this.dateAchat = dateAchat;
        this.remboursement = false;
    }


    public void rembourser(Utilisateur utilisateur)throws RemboursementImpossible {
        LocalDate dateAujourdhui = LocalDate.now();
        LocalDate verification30jours = dateAujourdhui.minusDays(DAYS_TO_SUBSTRACT);

        if(!this.getAssurance()){
            throw new RemboursementImpossible("Le billet ne contient pas d'assurance");
        }
        if(this.getDate().isBefore(LocalDate.now())){
            throw new RemboursementImpossible("Le vol est déjà passé");
        }
        if(this.getDateAchat().isBefore(verification30jours)){
            throw new RemboursementImpossible("Le billet a dépassé les 30 jours assurés");
        }

        this.annulerBillet();
        utilisateur.rembourser(this.price);
    }

    public void annulerBillet() {
        this.statut = 3;
    }

}
