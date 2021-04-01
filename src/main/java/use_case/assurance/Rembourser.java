package use_case.assurance;

import model.Billet;
import model.IBillet;

import java.time.LocalDate;

public class Rembourser {
    private final IBillet iBillet;


    public Rembourser(IBillet iBillet){
        this.iBillet = iBillet;
    }

    // Verifier que le billet est assurée
    // Vérifier que le vol n'est pas passé
    // Vérifier que le billet est acheté sous 30 jours
    public void effectuerRemboursement(Billet billet) throws RemboursementImpossible {
        LocalDate dateAujourdhui = LocalDate.now();
        LocalDate verification30jours = dateAujourdhui.minusDays(30);

        if(!billet.getAssurance()){
            throw new RemboursementImpossible("Le billet ne contient pas d'assurance");
        }
        if(billet.getDate().isBefore(LocalDate.now())){
            throw new RemboursementImpossible("Le vol est déjà passé");
        }
        if(billet.getDateAchat().isBefore(verification30jours)){
            throw new RemboursementImpossible("Le billet a dépassé les 30 jours assurés");
        }

        billet.setRemboursement(true);
    }

}
