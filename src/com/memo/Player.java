package com.memo;
public class Player {
    private int lives; // Número de vidas del jugador
    private int score; // Puntaje del jugador

    //Constructor de la clase Player
    public Player(int lives) {
        this.lives = lives;
        this.score = 0;
    }

    public int getLives() {
        return lives;
    } // Devuelve el número de vidas del jugador

    public int getScore() {
        return score;
    } // Devuelve el puntaje del jugador

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    } // Método para quitar vidas en caso de desacierto del jugador

    public void addScore(int points) {
        score += points;
    } // Método para sumar puntos en caso del acierto del jugador
}
