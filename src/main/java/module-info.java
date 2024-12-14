module bd.edu.seu.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens bd.edu.seu.calculator to javafx.fxml;
    exports bd.edu.seu.calculator;
}