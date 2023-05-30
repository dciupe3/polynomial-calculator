package Model.operation;

import Model.Monomial;
import Model.Polynomial;

public class MultiplyOperation implements Operation{
    @Override
    public Polynomial apply(Polynomial P1, Polynomial P2) {
        Polynomial result = new Polynomial();

        for(Monomial m1 : P1.getMonomials()){
            for(Monomial m2 : P2.getMonomials()){
                result.addNewMonomial(new Monomial(m1.getDegree() + m2.getDegree(), m1.getCoef() * m2.getCoef()));
            }
        }

        return result;
    }
}
