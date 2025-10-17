/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author adam
 */
public class GameState {
    private String labyrinth, players, monsters, log;
    private boolean winner;
    private int currentPlayer;
    
    GameState(String labyrinth, String players, String monsters, String log, 
            boolean winner, int currentPlayer){
        this.labyrinth=labyrinth;
        this.players=players;
        this.monsters=monsters;
        this.log=log;
        this.winner=winner;
        this.currentPlayer=currentPlayer;
    }
  
    public String getLabyrinth() {
        return labyrinth;
    }

    public String getPlayers() {
        return players;
    }

    public String getMonsters() {
        return monsters;
    }

    public String getLog() {
        return log;
    }

    public boolean getWinner() {
        return winner;
    }
    public boolean isWinner() {
        return winner;
    }
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setLabyrinth(String labyrinth) {
        this.labyrinth = labyrinth;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public void setMonsters(String monsters) {
        this.monsters = monsters;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
}
