package com.memo;

public class Card {
    private String value; // El valor de la carta (ejemplo: "🐵", "🐼")
    private boolean isRevealed; // Indica si la carta está boca arriba
    private boolean isMatched; // Indica si la carta ya fue emparejada

    // Constructor de la clase
    public Card(String value) {
        this.value = value;    // El valor se asigna al instanciar la clase
        this.isRevealed = false; // Por defecto la carta está boca abajo
        this.isMatched = false; // Por defecto la carta NO está emparejada
    }

    // Métodos públicos para interactuar con cada carta
    public String getValue() {
        return value;
    } // Devuelve el valor de la carta

    public boolean isRevealed() {
        return isRevealed;
    } // Retorna true o false si la carta está boca arriba

    public boolean isMatched() {
        return isMatched;
    } // Retorna true o false si la carta hizo match (coincide)

    public void reveal() {
        isRevealed = true;
    } // Hace que la carta esté revelada (La deja boca arriba)

    public void hide() {
        isRevealed = false;
    } // Oculta la carta (la deja boca abajo)

    public void markAsMatched() {
        isMatched = true;
    } // Marca la carta como matched (emparejada)
}
