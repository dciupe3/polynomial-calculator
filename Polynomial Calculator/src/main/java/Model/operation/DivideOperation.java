package Model.operation;

import Model.Monomial;
import Model.Polynomial;

public class DivideOperation implements Operation{
    @Override
    public Polynomial apply(Polynomial P1, Polynomial P2) {
        Polynomial quotient = new Polynomial(); //catul
        Polynomial remainder = new Polynomial(); //restul
        Polynomial newPoly = new Polynomial();

        if(P1.toString().equals(P2.toString())){
            quotient.addNewMonomial(new Monomial(0, 1.0));
        } else{
            for(Monomial m : P1.getMonomials()){
                newPoly.addNewMonomial(m.getCopy());
            }
            //Facem P1/P2, P2 are gradul mai mic, newPoly=P1
            /*  P1 = x^3 - 2x^2 + 6x - 5  = newPoly
                P2 = x^2 - 1

                x^3 - 2x^2 + 6x - 5 / x^2 - 1 = x - 2
                x^3 - x
                ----------
                -2x^2 + 7x - 5
                -2x^2 + 2
                -----------
                7x - 5
            */
            while(newPoly.getMonomials().getFirst().getDegree() >= P2.getMonomials().getFirst().getDegree() ){

                //impartirea primului termen
                Monomial quotientLastMonomial = new Monomial(newPoly.getMonomials().getFirst().getDegree() - P2.getMonomials().getFirst().getDegree(), (newPoly.getMonomials().getFirst().getCoef() * 1.0) / P2.getMonomials().getFirst().getCoef());
                quotient.addNewMonomial(quotientLastMonomial);
                //formam polinomul cu ultimul monom din cat
                Polynomial lastMonomPoly = new Polynomial();
                lastMonomPoly.addNewMonomial(quotientLastMonomial.getCopy());
                //inmultim catul cu P2
                remainder = P2.multiplyOperation(lastMonomPoly);
                //scadem
                remainder = newPoly.subOperation(remainder);
                newPoly.getMonomials().clear();
                for(Monomial m : remainder.getMonomials()){
                    newPoly.addNewMonomial(m.getCopy());
                }
                lastMonomPoly.getMonomials().clear();
            }
        }

        return quotient;
    }
}
