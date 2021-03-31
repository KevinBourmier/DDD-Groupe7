package recherche;

import model.Billet;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class SearchBilletTest {
    private final Billet billet;


    @Test
    public rechercher_should_return_two_billets(){

    }

    @Before
    public init(){
        this.billet = new Billet();
        this.billet.ajouterBillets(new Billet("testBillet", "KFJVUR", 200.50, "2021-06-21"));

    }

}
