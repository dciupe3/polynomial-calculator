package Model.operation;

import Model.Monomial;
import Model.Polynomial;

public class IntegrateOperation implements Operation{
    @Override
    public Polynomial apply(Polynomial P1, Polynomial P2) {
        Polynomial result = new Polynomial();
        Polynomial P3 = new Polynomial();

        if(P1.haveMonomials()){
            P3 = P1;
        }
        else if(P2.haveMonomials()){
            P3 = P2;
        }

        for(Monomial m : P3.getMonomials()){
            result.addNewMonomial(new Monomial(m.getDegree() + 1, m.getCoef() / (m.getDegree() + 1)));
        }

        return result;
    }
}
