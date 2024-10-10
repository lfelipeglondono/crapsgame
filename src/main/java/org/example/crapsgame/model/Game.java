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
    }

    public int getShoot() {

        return this.shoot;
    }

    public int getShootCount() {
        if (shoot!=2 && shoot!=3 && shoot!=12){
            shootCount++;
        }
        return this.shootCount;
    }

    public int getPoint() {
        if (shoot==5||shoot==6||shoot==8||shoot==9||shoot==5){
            point=shoot;
        }

        return this.point;
    }

    public boolean isWin() {
        win=false;
        if (shoot==7|| shoot==11){
            lose=true;
        }
        //si captura el punto antes de sacar 7
        if(shoot==point)
            win =true;
        return this.win;
    }

    public boolean isLose() {
        lose=false;
        if (shoot==2|| shoot==3||shoot==12){
            lose=true;
        }
        return this.lose;
    }

    public int rollDices(int dado1, int dado2) {
        shoot=dado1+dado2;

        return this.shoot;
    }

}
