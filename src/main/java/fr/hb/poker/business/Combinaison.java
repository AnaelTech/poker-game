package fr.hb.poker.business;


public enum Combinaison {
    HAUT_CARRE("Haut Carré"),
    CARRE("Carré"),
    FULL("Full"),
    COULEUR("Couleur"),
    QUINTE("Quinte"),
    BRELAN("Brelan"),
    DOUBLE_PAIRE("Double Paire"),
    PAIRE("Paire"),
    HAUTE_CARTE("Haute Carte");

    private final String description;

    Combinaison(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
