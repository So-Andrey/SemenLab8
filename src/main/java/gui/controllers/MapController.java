package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import localization.Lang;
import services.CurrentUserManager;
import services.OrganizationController;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    private final CurrentUserManager userManager;
    private final OrganizationController controller;
    private final double width;
    private final double height;
    private final Scene scene;
    private final Parent parent;
    private Stage stage;
    public MapController(double width, double height, CurrentUserManager userManager, OrganizationController controller) {
        this.userManager = userManager;
        this.controller = controller;
        this.width = width;
        this.height = height;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = fxmlLoader.load();
            scene = new Scene(parent, this.width, this.height);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
    public void launchMapScene(Stage stage) {
        this.stage = stage;
        stage.setScene(scene);

        stage.hide();
        stage.show();
    }

    @FXML
    private Button button_exit;

    @FXML
    private Button button_info;

    @FXML
    private Button button_clear;

    @FXML
    private Button button_table;

    @FXML
    private Label label_user;

    @FXML
    private Pane pane_map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLang();

    }

    private void setLang() {
        label_user.setText(Lang.getString("user") + " - " + userManager.getUserName());
    }

    private void setButton_clear() {
        controller.clear();
    }
}