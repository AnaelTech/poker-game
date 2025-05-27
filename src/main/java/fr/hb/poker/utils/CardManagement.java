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
}
