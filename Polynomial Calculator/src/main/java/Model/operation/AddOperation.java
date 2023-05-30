package Model.operation;

import Model.Monomial;
import Model.Polynomial;

public class AddOperation implements Operation{

    @Override
    public Polynomial apply(Polynomial P1, Polynomial P2) {
        Polynomial result = new Polynomial();

        for(Monomial m : P1.getMonomials()){
            result.addNewMonomial(m.getCopy());
        }

        for(Monomial m : P2.getMonomials()){
            result.addNewMonomial(m.getCopy());
        }

        return result;
    }
}
