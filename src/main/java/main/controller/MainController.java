package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField amountTf;

    @FXML
    private ChoiceBox<String> fromChoiceBox;

    @FXML
    private Label resultOfConvrsionLabel;

    @FXML
    private ChoiceBox<String> toChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupFromChoiceBox();
        setupToChoiceBox();
    }

    @FXML
    void handleConvertButton(ActionEvent event) {
        resultOfConvrsionLabel.setStyle("-fx-text-fill: #000000;");

        if (amountTf.getText().isEmpty()) {
            showError();
        } else {
            double result;
            double amountInput;
            
            //making sure user typed a number and not a letter
            try {
                amountInput = Double.parseDouble(amountTf.getText());
            } catch (NumberFormatException e) {
                showError();
                return;
            }

            //RSD to USD
            if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("RSD") && toChoiceBox.getSelectionModel().getSelectedItem().equals("USD")) {
                result = amountInput * 0.00931986;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            } else if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("USD") && toChoiceBox.getSelectionModel().getSelectedItem().equals("RSD")) {
                result = amountInput * 107.34;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            } else if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("RSD") && toChoiceBox.getSelectionModel().getSelectedItem().equals("EUR")) {
                result = amountInput * 0.0085;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            } else if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("EUR") && toChoiceBox.getSelectionModel().getSelectedItem().equals("RSD")) {
                result = amountInput * 117.67;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            } else if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("USD") && toChoiceBox.getSelectionModel().getSelectedItem().equals("EUR")) {
                result = amountInput * 0.91;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            } else if (fromChoiceBox.getSelectionModel().getSelectedItem().equals("EUR") && toChoiceBox.getSelectionModel().getSelectedItem().equals("USD")) {
                result = amountInput * 1.0963372;
                resultOfConvrsionLabel.setText(roundUpResult(result) + " " + toChoiceBox.getSelectionModel().getSelectedItem());
            }
        }


    }

    private void setupFromChoiceBox() {
        String[] currencyList = {"RSD", "USD", "EUR"};


        //getItems() returns ObserveableList object which you can add items to.
        fromChoiceBox.getItems().addAll(currencyList);

        //setting default value
        fromChoiceBox.setValue("RSD");
    }

    private void setupToChoiceBox() {
        String[] currencyList = {"RSD", "USD", "EUR"};

        //getItems() returns ObserveableList object which you can add items to.
        toChoiceBox.getItems().addAll(currencyList);

        //setting default value
        toChoiceBox.setValue("USD");
    }

    private double roundUpResult(double result) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(result));
    }

    private void showError() {
        resultOfConvrsionLabel.setStyle("-fx-text-fill: #D32F2F;");
        resultOfConvrsionLabel.setText("Enter a valid number!");
    }
}
