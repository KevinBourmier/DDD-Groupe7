package use_case.assurance;

import model.IUtilisateur;
import model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class FakeUtilisateur implements IUtilisateur {
    private final List<Utilisateur>  utilisateurs = new ArrayList();

    @Override
    public void save(Utilisateur utilisateur) {
        this.utilisateurs.add(utilisateur);
    }
}
