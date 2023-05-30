package Model;

import java.text.DecimalFormat;

public class Monomial {
    private Double coef;
    private Integer degree;

    public Monomial(Integer degree, Double coef){
        this.coef = coef;
        this.degree = degree;
    }

    public void setExp(Integer exp){
        this.degree = exp;
    }

    public void setCoef(Double coef){
        this.coef = coef;
    }

    public Integer getDegree(){
        return degree;
    }

    public Double getCoef(){
        return coef;
    }

    public String removeZero(Double number){
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format(number);
    }

    public String MonomialToString(){
        String monomString = "";
        switch (this.degree) {
            case 0:{
                //elementul liber sau x^0
                if(this.coef > 0.0)
                    monomString = "+" + removeZero(coef);
                else
                    monomString = removeZero(coef);
                break;
            }
            case 1:{
                if (coef == -1.0) {
                    monomString = "-x";
                } else if (coef == 1.0) {
                    monomString = "+x";
                }
                else{
                    if(coef > 0.0)
                        monomString = "+" + removeZero(coef) + "x";
                    else
                        monomString = removeZero(coef) + "x";
                }
                break;
            }
            default: {
                if (coef == -1.0) {
                    monomString = "-x" + "^" + String.valueOf(degree);
                } else if (coef == 1.0) {
                    monomString = "+x" + "^" + String.valueOf(degree);
                }
                else{
                    if(coef > 0.0)
                        monomString = "+" + removeZero(coef) + "x" + "^" + String.valueOf(degree);
                    else
                        monomString = removeZero(coef) + "x" + "^" + String.valueOf(degree);
                }
                break;
            }
        }
        return monomString;
    }

    public Monomial getCopy(){
        return new Monomial(this.degree, this.coef);
    }

    public Monomial getComplementCopy(){
        return new Monomial(this.degree, -1.0 * this.coef);
    }
}
