package com.example.crapsgame.models;

public class Game {
    private int winCount;
    private int loseCount;
    private int point;
    private  int lastRoll;
    private int rollCount;

    public Game(){
        winCount = 0;
        loseCount = 0;
        point = 0;
        rollCount = 0;
    }

    public void checkRoll(int rollScore){
        rollCount = rollCount +1;
        if (checkFirstRollWin(rollScore)&& checkIfFirstRoll(rollCount)){
            winCount = winCount +1;
        }

        else if (checkCrapsLose(rollScore) && checkIfFirstRoll(rollCount)){
            loseCount = loseCount +1;
        }

        else if (checkIfPoint(rollScore)&& point == 0){
            point = rollScore;
        }

        else if (checkPointWIn(rollScore)){
            winCount = winCount +1;
            point = 0;
        }

        else if(rollScore != point && rollScore == 7){
            loseCount = loseCount +1;
            point = 0;
        }
    }

    public boolean checkFirstRollWin(int rollScore){
        if (rollScore == 7 || rollScore == 11){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkCrapsLose(int rollScore){
        if (rollScore == 2 || rollScore == 3 || rollScore == 12){
            return true;
        }
        else return false;
    }

    public boolean checkIfPoint(int rollScore){
        if(rollScore == 4 || rollScore == 5 || rollScore == 6 || rollScore == 8 || rollScore == 9 || rollScore == 10){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkPointWIn(int rollScore){
        if (point == rollScore){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkIfFirstRoll(int rollCount){
        return rollCount == 1;
    }

    public int getWinCount(){
        return winCount;
    }

    public int getLoseCount(){
        return loseCount;
    }

    public int getPoint(){
        return point;
    }


}
