package Model.operation;

import Model.Monomial;
import Model.Polynomial;

public class SubOperation implements Operation{
    @Override
    public Polynomial apply(Polynomial P1, Polynomial P2) {
        Polynomial result = new Polynomial();

        for(Monomial m : P2.getMonomials()){
            result.addNewMonomial(m.getComplementCopy());
        }

        //P1 + (-P2);
        return result.addOperation(P1);
    }
}
