package use_case.assurance;

import model.Billet;
import model.IBillet;
import model.IUtilisateur;
import model.Utilisateur;

import java.time.LocalDate;

public class Rembourser {
    private final IUtilisateur iUtilisateur;


    public Rembourser(IUtilisateur iUtilisateur){
        this.iUtilisateur = iUtilisateur;
    }

    // Verifier que le billet est assurée
    // Vérifier que le vol n'est pas passé
    // Vérifier que le billet est acheté sous 30 jours
    public void effectuerRemboursement(String idBillet, Utilisateur utilisateur) throws Exception {
        Billet billet = utilisateur.findBillet(idBillet);
        billet.rembourser(utilisateur);
        iUtilisateur.save(utilisateur);
    }

}
