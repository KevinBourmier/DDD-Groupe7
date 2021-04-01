package use_case.assurance;

import model.Billet;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RembourserTest {

    @Test
    public void rembourser_should_return_true() throws RemboursementImpossible {
        Billet billet = new Billet(
                "KFeifev",
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                true,
                LocalDate.of(2021, 4, 1)
                );

        Rembourser rembourser = new Rembourser(new FakeBillet());

        rembourser.effectuerRemboursement(billet);
        assertTrue(billet.getRemboursement());
    }

    @Test
    public void rembourser_should_throw_exception_when_no_assurance() throws Exception {
        Billet billet = new Billet(
                "KFeifev",
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                false,
                LocalDate.of(2021, 4, 1)
        );

        Rembourser rembourser = new Rembourser(new FakeBillet());

        try {
            rembourser.effectuerRemboursement(billet);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le billet ne contient pas d'assurance");
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si pas d'assurance");
    }

    @Test
    public void rembourser_should_throw_exception_when_date_vol_passee() throws Exception {
        Billet billet = new Billet(
                "KFeifev",
                "99RHED",
                300.6,
                LocalDate.of(2021, 3, 13),
                true,
                LocalDate.of(2021, 4, 1)
        );

        Rembourser rembourser = new Rembourser(new FakeBillet());

        try {
            rembourser.effectuerRemboursement(billet);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le vol est déjà passé" );
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si la date du vol est passée");
    }

    @Test
    public void rembourser_should_throw_exception_when_assurance_depasse_30jours() throws Exception {
        Billet billet = new Billet(
                "KFeifev",
                "99RHED",
                300.6,
                LocalDate.of(2021, 4, 13),
                true,
                LocalDate.of(2021, 2, 1)
        );

        Rembourser rembourser = new Rembourser(new FakeBillet());

        try {
            rembourser.effectuerRemboursement(billet);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Le billet a dépassé les 30 jours assurés" );
            return;
        }

        throw new Exception("Effectuer remboursement doit planter si achat billet depasse 30 jours");
    }




}
