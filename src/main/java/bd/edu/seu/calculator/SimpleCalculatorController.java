package bd.edu.seu.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleCalculatorController {
    @FXML
    private TextField display; // Main display for inputs and results
    @FXML
    private Label textLabel; // Label to display the calculation history

    private String firstNumber = "";
    private String secondNumber = "";
    private String currentOperator = "";
    private String history = ""; // Holds the calculation history

    private double results = 0.0;

    private void displayHistory() {
        textLabel.setText(history);
    }

    // Displays the input numbers
    private void displayNumbers(String number) {
        if (currentOperator.isEmpty()) {
            firstNumber += number;
            history += number;
        } else {
            secondNumber += number;
            history += number;
        }
        display.setText(currentOperator.isEmpty() ? firstNumber : secondNumber);
        displayHistory();
    }

    public void button7Action(ActionEvent actionEvent) {
        displayNumbers("7");
    }

    public void button8Action(ActionEvent actionEvent) {
        displayNumbers("8");
    }

    public void button9Action(ActionEvent actionEvent) {
        displayNumbers("9");
    }

    public void buttonDivAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty())
            currentOperator = "/";
        else {
            calculation();
            currentOperator = "/";
        }
        history += currentOperator;
        displayHistory();
    }

    public void buttonBackAction(ActionEvent actionEvent) {
//        if any one click this button then the secound button number will be empty and remove from history
        if (!secondNumber.isEmpty()) {
            secondNumber = secondNumber.substring(0, secondNumber.length() - 1);
        } else if (!currentOperator.isEmpty()) {
            currentOperator = "";
        } else if (!firstNumber.isEmpty()) {
            firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
        }
        history = history.substring(0, history.length() - 1);
        display.setText(currentOperator.isEmpty() ? firstNumber : secondNumber);
        displayHistory();
    }

    public void buttonClearAction(ActionEvent actionEvent) {
        firstNumber = "";
        secondNumber = "";
        currentOperator = "";
        history = "";
        display.setText("");
        textLabel.setText("");
        results = 0.0;
    }

    public void button4Action(ActionEvent actionEvent) {
        displayNumbers("4");
    }

    public void button5Action(ActionEvent actionEvent) {
        displayNumbers("5");
    }

    public void button6Action(ActionEvent actionEvent) {
        displayNumbers("6");
    }

    public void buttonMulAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty())
            currentOperator = "x";
        else {
            calculation();
            currentOperator = "x";
        }
        history += currentOperator;
        displayHistory();
    }

    public void buttonOpenBracketAction(ActionEvent actionEvent) {
//        this button action is "("
    }

    public void buttonCloseBracketAction(ActionEvent actionEvent) {
        //        this button action is ")"
    }

    public void button1Action(ActionEvent actionEvent) {
        displayNumbers("1");
    }

    public void button2Action(ActionEvent actionEvent) {
        displayNumbers("2");
    }

    public void button3Action(ActionEvent actionEvent) {
        displayNumbers("3");
    }

    public void buttonMinusAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty())
            currentOperator = "-";
        else {
            calculation();
            currentOperator = "-";
        }
        history += currentOperator;
        displayHistory();
    }

    public void buttonXSquareAction(ActionEvent actionEvent) {
        if (!firstNumber.isEmpty()) {
            double num = Double.parseDouble(firstNumber);
            history = firstNumber + "^2";
            firstNumber = String.valueOf(num * num);
            display.setText(firstNumber);
            displayHistory();
        }
    }

    public void buttonXCubeAction(ActionEvent actionEvent) {
        if (!firstNumber.isEmpty()) {
            double num = Double.parseDouble(firstNumber);
            history = firstNumber + "^3";
            firstNumber = String.valueOf(num * num * num);
            display.setText(firstNumber);
            displayHistory();
        }
    }

    public void button0Action(ActionEvent actionEvent) {
        displayNumbers("0");
    }

    public void buttonPointAction(ActionEvent actionEvent) {
        displayNumbers(".");
    }

    public void buttonPrecentAction(ActionEvent actionEvent) {
        currentOperator = "%";
        history += currentOperator;
        displayHistory();
    }

    public void buttonPlusAction(ActionEvent actionEvent) {
        if (currentOperator.isEmpty())
            currentOperator = "+";
        else {
            calculation();
            currentOperator = "+";
        }
        history += currentOperator;
        displayHistory();

    }

    public void buttonResultAction(ActionEvent actionEvent) {
        calculation();
    }

    private void calculation(){
        // int or double?

        double fNum = Double.parseDouble(firstNumber);
        double sNum = Double.parseDouble(secondNumber);

        switch (currentOperator){
            case "+" ->{
                results = fNum+sNum;
                display.setText(String.valueOf(results));
            }
            case "-" -> {
                results = fNum-sNum;
                display.setText(String.valueOf(results));
            }

            case "x" ->{
                results = fNum*sNum;
                display.setText(String.valueOf(results));
            }

            case "/" -> {
                results = fNum/sNum;
                display.setText(String.valueOf(results));
            }

            case "%" -> {
                results = (fNum/100)*sNum;
                display.setText(String.valueOf(results));
            }
        }
        firstNumber = String.valueOf(results);
        secondNumber = "";
    }
}
