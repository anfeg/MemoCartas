package com.memo;

public class GameUI {
    public void displayWinMessage(int score){
        System.out.println("================================");
        System.out.println("¡Felicidades! ¡Ganaste el juego!".toUpperCase());
        System.out.println("Puntuación final: " + score);
        System.out.println("================================");
    }
    public void displayWelcomeMessage(){
        System.out.println("¡BIENVENIDO A MEMOCARTAS!");
        System.out.println("__________________________________");

    }
    public void displaySelectDifficultyMessage(){
        // Seleccionar el tamaño del tablero
        System.out.println();
        System.out.println("__________________________________");
        System.out.println("Selecciona la dificultad:");
        System.out.println();
        System.out.println("1. 2x2 (Test)");
        System.out.println("2. 4x4 (Fácil)");
        System.out.println("3. 6x6 (Intermedio)");
        System.out.println("4. 8x8 (Avanzado)");
        System.out.println("__________________________________");
        System.out.print("Ingresa tu opción: ");
    }
    public void displaySelectThemeMessage(){
        System.out.println();
        System.out.println("__________________________________");
        System.out.println("Selecciona la temática de las cartas:");
        System.out.println();
        System.out.println("1. Animales");
        System.out.println("2. Paisajes");
        System.out.println("3. Emojis");
        System.out.println("__________________________________");
        System.out.print("Ingresa tu opción: ");
    }
    public void displayLoseMessage(){
        System.out.println("==========================================");
        System.out.println("¡Juego terminado! Te quedaste sin vidas 😓");
        System.out.println("==========================================");
    }
    public void displaySelectDiferentCardMessage(){
        System.out.println("======================================================");
        System.out.println("Por favor selecciona una carta diferente a la anterior");
        System.out.println("======================================================");
    }
    public void displayisAlreadyMatchedCardMessage(){
        System.out.println("=======================================================");
        System.out.println("Esta carta ya está emparejada, selecciona una diferente");
        System.out.println("=======================================================");
    }
    public void displayMatchFoundMessage(){
        System.out.println("======================");
        System.out.println("¡Pareja encontrada! ✅");
        System.out.println("======================");
    }
    public void displayMatchNotFoundMessage(){
        System.out.println("=============================");
        System.out.println("❌ Las cartas no coinciden...");
        System.out.println("=============================");
    }
}