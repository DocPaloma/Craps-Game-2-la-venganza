package com.example.crapsgame.models;

import javafx.scene.control.Alert;

public class AlertBoxAyuda implements AlertBoxInterface {

    @Override
    public void showAlertBox(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.getDialogPane().setPrefSize(400, 400);
        alert.showAndWait();
    }

    public boolean showConfirmAlertBox(String title, String header, String content) {
        return false;
    }
}
