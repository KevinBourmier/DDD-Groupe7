package model;

import java.util.ArrayList;
import java.util.UUID;

public class Utilisateur {

    private String id;
    private String nom;
    private String prenom;
    private String mail;



    private double compte_bancaire;
    private final ArrayList<Billet> billets;

    public Utilisateur(String nom, String prenom, String mail, double compte_bancaire) {
        this.id = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.compte_bancaire = compte_bancaire;
        this.billets = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void ajouterBillet(Billet billet) {
        this.billets.add(billet);
    }

    public void rembourser(double montant) {
        this.compte_bancaire += montant;
    }

    public Billet findBillet(String idBillet) throws Exception {
        return this.billets.stream()
                .filter(billet -> billet.getId() == idBillet)
                .findFirst()
                .orElseThrow(()-> new Exception("Impossible de trouver le billet"));
    }
    public double getCompte_bancaire() {
        return compte_bancaire;
    }
}
