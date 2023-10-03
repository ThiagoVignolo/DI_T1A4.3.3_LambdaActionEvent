package es.ieslosmontecillos.di_t1a433_lambda_actionevent;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static java.lang.Math.pow;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        //GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setAlignment(Pos.CENTER_RIGHT);

        //Labels
        Label lblAnnualInterest = new Label("Annual Interest Rate: ");
        Label lblNumbersYears = new Label("Numbers of Years: ");
        Label lblLoanAmount = new Label("Loan Amount: ");
        Label lblMonthlyPayment = new Label("Monthly Payment: ");
        Label lblTotalPayment = new Label("Total Payment: ");

        //TextFields
        TextField tfAnualInterest = new TextField();
        TextField tfNumbersYears = new TextField();
        TextField tfLoanAmount = new TextField();
        TextField tfMonthlyPayment = new TextField();
        TextField tfTotalPayment = new TextField();

        //Button
        Button btnCalculate = new Button("Calculate");

        //GridPane adding
        gridPane.add(lblAnnualInterest,0,0);
        gridPane.add(lblNumbersYears,0,1);
        gridPane.add(lblLoanAmount,0,2);
        gridPane.add(lblMonthlyPayment,0,3);
        gridPane.add(lblTotalPayment,0,4);

        gridPane.add(tfAnualInterest,1,0);
        gridPane.add(tfNumbersYears,1,1);
        gridPane.add(tfLoanAmount,1,2);
        gridPane.add(tfMonthlyPayment,1,3);
        gridPane.add(tfTotalPayment,1,4);

        gridPane.add(btnCalculate,1,5);



        //Lmbada expresion
        btnCalculate.setOnAction(e -> {
            double monthlyPayment  = calculateMonthlyAmount(tfLoanAmount.getText(), tfNumbersYears.getText(), tfAnualInterest.getText());

            tfMonthlyPayment.setText("€" + monthlyPayment);
            tfTotalPayment.setText("€" + (30*12*monthlyPayment));
        });


        Scene scene = new Scene(gridPane, 300, 200);
        stage.setTitle("LambdaActionEvent");
        stage.setScene(scene);
        stage.show();
    }

    //Function, Monthly Amount calculation
    private double calculateMonthlyAmount(String loanAmount, String numbersYears, String anualInterest)
    {
        double revenue = Double.parseDouble(anualInterest) /(100*12);
        double loan = Double.parseDouble(loanAmount);
        double years = Double.parseDouble(numbersYears);

        return (loan * revenue)/(1-(1/(pow((1+revenue), (12*years)))));
    }

    public static void main(String[] args) {
        launch();
    }
}