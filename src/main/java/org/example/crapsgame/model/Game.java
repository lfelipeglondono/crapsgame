package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {


        return this.point;
    }

    public boolean isWin() {
        if (shootCount == 0) {
            if (shoot == 7 || shoot == 11){
                win = true;
            }
        }

        else {
            if(shoot == point) {
                win = true;
            }
        }



        return win;
    }

    public boolean isLose() {
        if (shootCount == 0 && (shoot == 2 || shoot == 3 || shoot == 12)) {
            lose = true;
        }
        else if (shootCount != 0 && shoot == 7) {
            lose = true;
        }

        return lose;
    }

    public int rollDices(int dado1, int dado2) {
        shoot=dado1+dado2;

        if (point == 0 && (shoot==5 || shoot==6 || shoot==8 || shoot==9)) {

            point=shoot;

        }

        shootCount++;

        return this.shoot;
    }

}
