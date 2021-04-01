package use_case.assurance;

import model.Billet;
import model.IBillet;

public class FakeBillet implements IBillet {
    @Override
    public Billet save(Billet billet) {
        return null;
    }
}
