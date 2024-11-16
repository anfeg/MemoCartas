package com.memo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Board {
    private final Card[][] cards; // Matriz bidimensional para representar el tablero
    private final int size; // Tamaño del tablero size x size, DEBE ser un número PAR (ejemplo: 4x4)
    private String[] selectedTheme;


    // Constructor
    public Board(int size, String[] themes) {
        this.size = size;
        this.selectedTheme = themes;
        this.cards = new Card[size][size];
        initializeBoard(themes);
    }

    // Inicializa el tablero
    private void initializeBoard(String[] themes) {
        ArrayList<Card> allCards = new ArrayList<>();
        int pairs = (size * size) / 2;

        // Convertir el array de temas a una lista para facilitar la selección aleatoria
        ArrayList<String> themeList = new ArrayList<>(Arrays.asList(themes));

        // Verificar que hay suficientes temas únicos
        if (themeList.size() < pairs) {
            throw new IllegalArgumentException("No hay suficientes temas para crear todas las parejas.");
        }

        // Seleccionar pares aleatorios de temas
        Random random = new Random();
        for (int i = 0; i < pairs; i++) {
            int randomIndex = random.nextInt(themeList.size());
            String selectedTheme = themeList.get(randomIndex);

            // Crear un par de cartas con el tema seleccionado
            allCards.add(new Card(selectedTheme));
            allCards.add(new Card(selectedTheme));

            // Remover el tema para que no se repita
            themeList.remove(randomIndex);
        }

        // Mezclar cartas
        Collections.shuffle(allCards);

        // Colocar las cartas en el tablero
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cards[i][j] = allCards.get(index++);
            }
        }
    }

    // Muestra el tablero
    public void displayBoard(boolean showAll) {
        for (int i = 0; i < size; i++) {
                    System.out.println();
            for (int j = 0; j < size; j++) {
                Card card = cards[i][j];
                if (card.isRevealed() || showAll) {
                    System.out.print("    " + card.getValue() + "    ");
                } else {
                    System.out.print("  ["+(i+1)+"]["+(j+1)+"]" + "X  ");
                }
            }
            System.out.println();
        }
    }

    // Obtiene una carta específica
    public Card getCard(int x, int y) {
        return cards[x][y];
    }

    // Método para acceder a todas las cartas
    public Card[][] getCards() {
        return cards;
    }
}
