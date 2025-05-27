package fr.hb.poker.utils;

import java.util.ArrayList;
import java.util.Collections;

import fr.hb.poker.business.Card;
import fr.hb.poker.business.Color;
import fr.hb.poker.business.Player;

public class CardManagement {


private ArrayList<Card> cards;
private ArrayList<Color> colors;
private ArrayList<Player> players;


public CardManagement(ArrayList<Player> players) {
    this.cards = new ArrayList<>();
    this.colors = new ArrayList<>();
    this.players = players;
}


public void startGame(){
    setColors();
    createDeck();
    distributeCards(players, cards);
  }

public void setColors(){
    String[] colorNames = {"Heart", "Diamond", "Spade", "Club"};
    for (String colorName : colorNames) {
        colors.add(new Color(colorName));
    }
  }

public ArrayList<Card> createDeck(){
  for (Color color : colors) {
        for (int value = 2; value <= 14; value++) {
            cards.add(new Card(value, color));
        }
    }
    shuffleDeck(cards);
    return cards;
      }

public void shuffleDeck(ArrayList<Card> cards) {
    Collections.shuffle(cards);
  }

public void distributeCards(ArrayList<Player> players, ArrayList<Card> cards) {
    int cardsPerPlayer = 5;
    for (Player player : players) {
        for (int i = 0; i < cardsPerPlayer; i++) {
            if (!cards.isEmpty()) {
                player.getHand().add(cards.remove(0));
            }
        }
    }
  }

public void setPlayers(ArrayList<Player> players) {
    this.players = players;
}

public ArrayList<Player> getPlayers() {
    return players;
  }

public void analyseHand(Player player) {
    // Si main du joueur égale a  As-Roi-Dame-Valet-10 et qu'ils ont la meme couleur alors il a une quite flush royale
    
    // Case si chiffre se suit et de la meme couleur quinte flush
    
    // Case si 4 cartes de meme valeur alors il a un carré
    
    // Case son 3 cartes de meme valeur alors il a un brelan
    
    // Case si 2 cartes de meme valeur alors il a une paire
    
    // Case si 2 cartes de meme valeur et 2 autres cartes de meme valeur alors il a un double paire
    
    // Case si 5 cartes de meme couleur alors il a une Couleur
    
    // Case si 5 cartes se suivent alors il a une Quinte
    
    // Case si carte la plus haute alors il a une carte haute
  }

}
