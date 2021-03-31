package use_case.recherche;

import model.Billet;

import java.util.ArrayList;
import java.util.Date;

public class SearchBillet {
    private final Billet billet;

    public SearchBillet(Billet billet) {
        this.billet = billet;
    }


    public ArrayList<Billet> rechercher(Date date, String destination){
        return billet.rechercher();
    }
}
