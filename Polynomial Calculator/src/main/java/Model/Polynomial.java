package Model;

import Model.operation.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Monomial>monomials;

    public Polynomial(LinkedList<Monomial>_monomials) {
        this.monomials = _monomials;
    }

    public Polynomial(){
        monomials = new LinkedList<Monomial>();
    }

    public LinkedList<Monomial> getMonomials(){
        return monomials;
    }

    public String toString(){
        String polyString = "";
        // -3x^3-4x^2-x+3
        for(Monomial monomial : this.getMonomials()){
            polyString += monomial.MonomialToString();
        }

        //daca incepe cu '0'
        if(polyString.indexOf("+") == 0)
            polyString = polyString.substring(1, polyString.length());
        return polyString;
    }

    public boolean haveMonomials(){
        return !monomials.isEmpty();
    }

    public void addNewMonomial(Monomial monomial){

        boolean duplicate = false;
        if(monomials.isEmpty()){
            duplicate = true;
            monomials.add(monomial);
        }
        else{
            for(Monomial m : monomials){
                if(m.getDegree().equals(monomial.getDegree())){
                    m.setCoef(m.getCoef() + monomial.getCoef());
                    duplicate = true;
                    break;
                }
            }
        }

        if(!duplicate)
            monomials.add(monomial);
        //eliminam monoamele care au coef 0 dupa adunare
        Iterator<Monomial> iterator = monomials.iterator();
        while(iterator.hasNext()){
            Monomial nextMonomial = iterator.next();
            if(nextMonomial.getCoef().equals(0.0) || nextMonomial.getCoef().equals(-0.0)){
                iterator.remove();
            }
        }

        //sortam in functie de grad
        monomials.sort(new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                return o2.getDegree() - o1.getDegree();
            }
        });
    }

    public Polynomial addOperation(Polynomial polynomial){
        AddOperation op = new AddOperation();
        return op.apply(this, polynomial);
    }

    public Polynomial subOperation(Polynomial polynomial){
        SubOperation op = new SubOperation();
        return op.apply(this, polynomial);
    }

    public Polynomial multiplyOperation(Polynomial polynomial){
        MultiplyOperation op = new MultiplyOperation();
        return op.apply(this, polynomial);
    }

    public Polynomial divideOperation(Polynomial polynomial){
        DivideOperation op = new DivideOperation();
        return op.apply(this, polynomial);
    }

    public Polynomial deriveOperation(){
        DeriveOperation op = new DeriveOperation();
        return op.apply(this, this);
    }

    public Polynomial integrateOperation(){
        IntegrateOperation op = new IntegrateOperation();
        return op.apply(this, this);
    }
}
