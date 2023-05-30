package Model;

import Model.operation.*;
import Service.RegexService;

public class CalculatorModel {
    private final RegexService regexService;

    public CalculatorModel() {
        this.regexService = new RegexService();
    }

    public Polynomial doOperation(String firstPolynomial, String secondPolynomial, OperationType operationType) {
        Polynomial poly1 = regexService.getPolynomialFromString(firstPolynomial);
        Polynomial poly2 = regexService.getPolynomialFromString(secondPolynomial);
        switch (operationType){
            case ADD: {
                AddOperation addOperation = new AddOperation();
                return addOperation.apply(poly1, poly2);
            }
            case SUBSTRACT: {
                SubOperation subOperation = new SubOperation();
                return subOperation.apply(poly1, poly2);
            }
            case MULTIPLY: {
                MultiplyOperation multiplyOperation = new MultiplyOperation();
                return multiplyOperation.apply(poly1, poly2);
            }
            case DIVIDE: {
                DivideOperation divideOperation = new DivideOperation();
                return divideOperation.apply(poly1, poly2);
            }
            case DERIVE: {
                DeriveOperation deriveOperation = new DeriveOperation();
                return deriveOperation.apply(poly1, poly2);
            }
            case INTEGRATE: {
                IntegrateOperation integrateOperation = new IntegrateOperation();
                return integrateOperation.apply(poly1, poly2);
            }
        }

        return null;
    }
}
