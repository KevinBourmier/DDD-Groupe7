package recherche;

import model.Billet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import use_case.recherche.SearchBillet;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SearchBilletTest {
    private Billet billet;
    private SearchBillet searchBillet;


    @Test
    public void rechercher_should_return_two_billets(){
        ArrayList<Billet> result = this.billet.rechercher();
        assertEquals(result.size(), 2);
    }

    @Before
    public void init(){
        this.billet = new Billet();
        this.billet.ajouterBillets(new Billet("testBillet", "KFJVUR", 200.50, "2021-06-21"));

        this.billet =
        this.billet = new Billet("testBillet2", "KFJVUR22", 200.50, "2021-06-21");
        this.billet.ajouterBillets(billet);
    }

}
