/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package client.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucht
 */
public class RegisterFXMLController implements Initializable {

    @FXML
    private AnchorPane contentAnchorPane;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField phonenumberTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private CheckBox adminCheckbox;
    @FXML
    private Button registerButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button dashboardButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerButtonHandler(ActionEvent event) {
    }

    @FXML
    private void clearButtonHandler(ActionEvent event) {
    }

    @FXML
    private void dashboardButtonHandler(ActionEvent event) {
    }
    
}