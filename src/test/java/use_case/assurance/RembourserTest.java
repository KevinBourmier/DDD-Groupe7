package use_case.assurance;

import model.Billet;
import model.Utilisateur;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RembourserTest {

    @Test
    public void rembourser_should_return_true() throws Exception {
        Billet billet = new Billet(
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                true,
                LocalDate.of(2021, 4, 1)
                );
        Utilisateur utilisateur = new Utilisateur(
                "Kevin",
                "brugnet",
                "Rubayiza@gmail.com",
                4000
        );
        utilisateur.ajouterBillet(billet);

        Rembourser rembourser = new Rembourser(new FakeUtilisateur());

        rembourser.effectuerRemboursement(billet.getId(), utilisateur);
        assertEquals(billet.getStatut(), 3);
        assertEquals(utilisateur.getCompte_bancaire(), 4000 + 300.6, 1);
    }

    @Test
    public void rembourser_should_throw_exception_when_no_assurance() throws Exception {
        Billet billet = new Billet(
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                false,
                LocalDate.of(2021, 4, 1)
        );
        Utilisateur utilisateur = new Utilisateur(
                "Kevin",
                "brugnet",
                "Rubayiza@gmail.com",
                4000
        );
        utilisateur.ajouterBillet(billet);

        Rembourser rembourser = new Rembourser(new FakeUtilisateur());

        try {
            rembourser.effectuerRemboursement(billet.getId(), utilisateur);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le billet ne contient pas d'assurance");
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si pas d'assurance");
    }

    @Test
    public void rembourser_should_throw_exception_when_date_vol_passee() throws Exception {
        Billet billet = new Billet(
                "99RHED",
                300.6,
                LocalDate.of(2021, 1, 13),
                true,
                LocalDate.of(2021, 1, 1)
        );
        Utilisateur utilisateur = new Utilisateur(
                "Kevin",
                "brugnet",
                "Rubayiza@gmail.com",
                4000
        );
        utilisateur.ajouterBillet(billet);

        Rembourser rembourser = new Rembourser(new FakeUtilisateur());

        try {
            rembourser.effectuerRemboursement(billet.getId(), utilisateur);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le vol est déjà passé" );
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si la date du vol est passée");
    }

    @Test
    public void rembourser_should_throw_exception_when_assurance_depasse_30jours() throws Exception {
        Billet billet = new Billet(
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                true,
                LocalDate.of(2021, 2, 22)
        );
        Utilisateur utilisateur = new Utilisateur(
                "Kevin",
                "brugnet",
                "Rubayiza@gmail.com",
                4000
        );
        utilisateur.ajouterBillet(billet);

        Rembourser rembourser = new Rembourser(new FakeUtilisateur());

        try {
            rembourser.effectuerRemboursement(billet.getId(), utilisateur);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le billet a dépassé les 30 jours assurés" );
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si achat billet depasse 30 jours");
    }
}
