package gui.controllers;

import gui.utils.SpecialWindows;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.CurrentUserManager;
import services.OrganizationController;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label label_error_msg;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField pf_password;
    private final CurrentUserManager userManager;
    private final OrganizationController controller;
    private final double width;
    private final double height;
    private final Scene scene;
    private final Parent parent;
    private Stage stage;
    private boolean login = true;
    public LoginController(double width, double height, CurrentUserManager userManager, OrganizationController controller) {
        this.userManager = userManager;
        this.controller = controller;
        this.width = width;
        this.height = height;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = fxmlLoader.load();
            scene = new Scene(parent, this.width, this.height);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
    public void launchLoginScene(Stage stage) {
        this.stage = stage;
        stage.setScene(scene);

        stage.hide();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        close_button.setOnAction(e -> close());
        button_login.setOnAction(e -> loginButtonOnAction());
        button_sign_up.setOnAction(e -> signupButtonOnAction());
    }

    @FXML
    private Button close_button;
    private void close(){
        if (SpecialWindows.showConfirmationDialog("U sure wanna exit?")){
            System.exit(1);
        }
    }

    private boolean checkFields() {
        if (!tf_username.getText().isBlank() && !pf_password.getText().isBlank()) {
            label_error_msg.setText("Attempt"); //todo
            return true;
        }
        if (tf_username.getText().isBlank() || pf_password.getText().isBlank()) {
            label_error_msg.setText("Should not be empty"); //todo
        }
        return false;
    }

    @FXML
    private Button button_sign_up;
    @FXML
    private Label label_login;
    @FXML
    private Label label_username;
    @FXML
    private Label label_password;
    @FXML
    private Label label_no_acc;
    @FXML
    private Button button_login;
    public void signupButtonOnAction() {
        if (login){
            login = false;
            label_login.setText("Register");
            label_no_acc.setText("Have acc?"); //todo
            button_login.setText("Sign up"); //todo
            button_sign_up.setText("Log In");
        } else {
            login = true;
            label_login.setText("Login");
            label_no_acc.setText("no acc?");
            button_login.setText("Log in");
            button_sign_up.setText("Sign Up");
        }
    }

    public void loginButtonOnAction() {
        if (!login){
            if (checkFields()) {
                String username = tf_username.getText();
                if (!controller.getUserNameList().contains(username)) {
                    userManager.setUserName(username);
                    controller.userRegister(username, pf_password.getText());
                    label_error_msg.setText("Success"); //todo
//                    new MainController(width, height, userManager, controller).launchMainScene(stage);
                } else {
                    label_error_msg.setText("Nickname exist"); //todo
                }
            }
        } else {
            if (checkFields()) {
                String username = tf_username.getText();
                if (controller.checkUserPassword(username, pf_password.getText())) {
                    userManager.setUserName(username);
                    label_error_msg.setText("Success"); //todo
//                    new MainController(width, height, userManager, controller).launchMainScene(stage);
                } else {
                    label_error_msg.setText("Invalid"); //todo
                }
            }
        }
    }


}