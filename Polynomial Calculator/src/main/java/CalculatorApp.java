import Controller.CalculatorController;
import Model.CalculatorModel;
import View.CalcView;

public class CalculatorApp {
    public static void main(String[] args){
        CalculatorModel model = new CalculatorModel();
        CalcView view = new CalcView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.start();
    }
}
