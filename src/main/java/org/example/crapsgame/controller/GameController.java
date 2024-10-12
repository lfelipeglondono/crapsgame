package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Excepcion;
import org.example.crapsgame.model.Game;
import org.example.crapsgame.view.alert.AlertBox;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel, shotLabel1, pointLabel1;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    @FXML
    private Button helpButton;


    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();
    int wins, losses;

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.wins = 0;
        this.losses = 0;
        games.add(new Game());
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());

        games.get(games.size() - 1).rollDices(dice1.getValue(), dice2.getValue());
        shootLabel.setText(String.valueOf(games.get(games.size() - 1).getShoot()));
        pointLabel.setText(String.valueOf(games.get(games.size() - 1).getPoint()));


        try {

            Exception e= new Exception("causa de la excepción");
            if (games.get(games.size() - 1).isLose()) {
                if (games.get(games.size() - 1).getShootCount() ==1)
                {
                    throw new Excepcion("perdiste en el primer intento", e);

                }
                else{
                    throw new Excepcion("perdiste despues del primer intento", e);
                }
            }

        }
        catch(Excepcion e){
            new AlertBox().showMessage(
                    "Perdiste",
                    "¡Ops! Perdiste",
                    e.getMessage()
            );
            games.add(new Game());
            losses++;
        }




        if (games.get(games.size() -1).isWin()) {
            games.add(new Game());
            wins++;
        }

        shootLabel.setText(String.valueOf(games.get(games.size() - 1).getShoot()));
        pointLabel.setText(String.valueOf(games.get(games.size() - 1).getPoint()));

        System.out.println("tamaño" + String.valueOf(games.size()));
        System.out.println("contador" + String.valueOf(games.get(games.size() - 1).getShootCount()));

        shotLabel1.setText(String.valueOf(wins));
        pointLabel1.setText(String.valueOf(losses));

    }
    @FXML
    void onActionHelpButton(ActionEvent event) {
        new AlertBox().showMessage(
                "Información",
                "Explicación General",
                "El juego inicia cuando el jugador hace su lanzamiento o tiro de salida. " +
                        "Si en este lanzamiento sacas un 7 u 11, ganas automáticamente. Si sacas un 2, 3 o 12, es un Craps y pierdes. " +
                        "Cualquier otro número (4,5, 6, 8, 9, 10) establece el punto. Si el jugador establece punto, puede seguir lanzando con el objetivo de intentar sacar ese mismo número otra vez. " +
                        "Si logras sacar el punto antes de sacar un 7, ganas. Si sacas un 7 antes del punto, pierdes."

        );

    }
}
