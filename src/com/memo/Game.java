package com.memo;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player;
    private final GameUI ui;
    private final int cardsVisivilityTime;
    private final int timer;
    private boolean isGameOver;

    public Game(int lives, int timer) {
        this.ui = new GameUI();
        ui.displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);

        // Selección de dificultad
        ui.displaySelectDifficultyMessage();
        int sizeSelected = scanner.nextInt();
        int size = mapSizeSelection(sizeSelected);

        // Selección de tema
        ui.displaySelectThemeMessage();
        int themeSelected = scanner.nextInt();
        String[] theme = mapThemeSelection(themeSelected);

        this.board = new Board(size, theme);
        this.player = new Player(lives);
        this.cardsVisivilityTime = calculateVisivilityTime(sizeSelected);
        this.timer = timer;
        this.isGameOver = false;
    }

    private int calculateVisivilityTime(int sizeSelected) {
        return switch (sizeSelected) {
            case 1 -> 5000; // 5 segundos para nivel test
            case 2 -> 10000; // 10 segundos para nivel fácil
            case 3 -> 20000; // 20 segundos para nivel Intermedio
            case 4 -> 30000; // 30 segundos para nivel Avanzado
            default -> 8000; // Tiempo por defecto
        };
    }

    private int mapSizeSelection(int sizeSelected) {
        return switch (sizeSelected) {
            case 1 -> 2;
            case 2 -> 4;
            case 3 -> 6;
            case 4 -> 8;
            default -> {
                System.out.println("Opción no válida. Se usará el tamaño 4x4 por defecto.");
                yield 4;
            }
        };
    }

    private String[] mapThemeSelection(int themeSelected) {
        return switch (themeSelected) {
            case 1 -> Themes.ANIMALES;
            case 2 -> Themes.PAISAJES;
            case 3 -> Themes.EMOJIS;
            default -> {
                System.out.println("Tema no válido. Se seleccionará el tema de animales por defecto.");
                yield Themes.ANIMALES;
            }
        };
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        board.displayBoard(true);
        try {
            Thread.sleep( cardsVisivilityTime); // Mostrar el tablero por X segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!isGameOver) {
            System.out.println("\nVidas: " + player.getLives() + " | Tiempo: " + timer + "s | Puntuación: " + player.getScore());
            board.displayBoard(false);


            // Selección de la primera carta
            Card card1 = null;
            do {
                System.out.print("Selecciona la primera carta (fila): ");
                int x1 = scanner.nextInt() - 1;
                System.out.print("Selecciona la primera carta (columna): ");
                int y1 = scanner.nextInt() - 1;
                card1 = board.getCard(x1, y1);
                if (card1.isMatched()) {
                    ui.displayisAlreadyMatchedCardMessage();
                }
            } while (card1.isMatched());
            card1.reveal();
            board.displayBoard(false);

            // Selección de la segunda carta
            Card card2 = null;
            do {
                System.out.print("Selecciona la segunda carta (fila): ");
                int x2 = scanner.nextInt() - 1;
                System.out.print("Selecciona la segunda carta (columna): ");
                int y2 = scanner.nextInt() - 1;
                card2 = board.getCard(x2, y2);
                if (card2 == card1){
                    ui.displaySelectDiferentCardMessage();
                }
                if (card2.isMatched()) {
                    ui.displayisAlreadyMatchedCardMessage();
                }
            } while (card2.isMatched() || card2 == card1); // Evita que seleccione la misma carta dos veces
            card2.reveal();
            board.displayBoard(false);

            // Comparar las dos cartas seleccionadas
            if (card1.getValue().equals(card2.getValue())) {
                ui.displayMatchFoundMessage();
                card1.markAsMatched();
                card2.markAsMatched();
                player.addScore(10);
            } else {
                ui.displayMatchNotFoundMessage();
                card1.hide();
                card2.hide();
                player.loseLife();
            }

            checkGameOver();
        }
        scanner.close();
    }

    private void checkGameOver() {
        if (player.getLives() <= 0) {
            isGameOver = true;
            ui.displayLoseMessage();
        }

        boolean allMatched = true;
        for (Card[] row : board.getCards()) {
            for (Card card : row) {
                if (!card.isMatched()) {
                    allMatched = false;
                    break;
                }
            }
        }

        if (allMatched) {
            isGameOver = true;
            ui.displayWinMessage(player.getScore());
        }
    }
}
