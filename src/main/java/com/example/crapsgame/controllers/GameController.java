package com.example.crapsgame.controllers;

import com.example.crapsgame.models.AlertBox;
import com.example.crapsgame.models.AlertBoxAyuda;
import com.example.crapsgame.models.Dice;
import com.example.crapsgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private Label nicknameLabel;

    @FXML
    private Label rollScoreLabel;

    @FXML
    private ImageView diceImageView1;

    @FXML
    private ImageView diceImageView2;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void showNicknameLabel() {
        nicknameLabel.setText(player.getNickname());
    }

    @FXML
    void onActionPlayButton(ActionEvent event) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        int rollScore = dice1.roll() + dice2.roll();

        this.diceImageView1.setImage(new Image(getClass().getResourceAsStream(
                dice1.getDiceImagePath()
        )));
        this.diceImageView2.setImage(new Image(getClass().getResourceAsStream(
                dice2.getDiceImagePath()
        )));
        this.rollScoreLabel.setText(String.valueOf(rollScore));
    }

    @FXML
    void onActionButtonAyuda(ActionEvent event) {
        new AlertBoxAyuda().showAlertBox("INSTRUCCIONES",
                "Instrucciones de uso del juego",
                "El juego inicia cuando el jugador hace su lanzamiento o tiro de salida. \n" +
                        "Si en este lanzamiento sacas un 7 u 11, ganas automáticamente. \n" +
                        "Si sacas un 2, 3 o 12, es un \"Craps\" y pierdes. \n" +
                        "Cualquier otro número (4,5, 6, 8, 9, 10) establece el \"punto\". \n" +
                        "Si el jugador establece \"punto\", puede seguir lanzando con el objetivo \n" +
                        "de intentar sacar ese mismo número otra vez. Si logras sacar \n" +
                        "el \"punto\" antes de sacar un 7, ganas. Si sacas un 7 antes del punto, pierdes.");

    }
}
