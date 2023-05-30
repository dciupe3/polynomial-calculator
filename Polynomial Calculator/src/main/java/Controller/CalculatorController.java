package Controller;

import Model.CalculatorModel;
import Model.OperationType;
import Model.Polynomial;
import View.CalcView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalcView view;


    public CalculatorController(CalculatorModel m, CalcView v){
        model = m;
        view = v;
        addListeners();
    }

    public void start(){
        view.open();
    }

    private void addListeners(){
        view.addAddListener(new AddListener());
        view.addSubstactListener(new SubListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDivideListener(new DivideListener());
        view.addDeriveListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
    }

    /**---------- CLASELE ACTIONLISTENER ---------- **/
    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.ADD);
                view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }
    class SubListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.SUBSTRACT);
                view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }
    class MultiplyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.MULTIPLY);
                view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }
    class DivideListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.DIVIDE);
                view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }
    class DerivateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.DERIVE);
                view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }
    class IntegrateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String firstPolyString = view.getFirstPolynomial();
                String secondPolyString = view.getSecondPolynomial();
                Polynomial result = model.doOperation(firstPolyString, secondPolyString, OperationType.INTEGRATE);
                if(!result.toString().isEmpty())
                    view.setResult(result.toString() + "+C");
                else
                    view.setResult(result.toString());
            }
            catch (Exception exception){
                view.showError("Eroare");
            }
        }
    }

}
