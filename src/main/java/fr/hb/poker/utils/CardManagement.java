package fr.hb.poker.utils;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;

import fr.hb.poker.business.Card;
import fr.hb.poker.business.Color;
import fr.hb.poker.business.Combinaison;
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

public Combinaison analyseHand(Player player) { 
    int[] occurrences = new int[15]; 
    int[] colorCount = new int[4]; 
    
    for (Card card : player.getHand()) {
        occurrences[card.getValue()]++;
        String suit = card.getColor().getName(); 
        switch (suit) {
            case "Heart" -> colorCount[0]++;
            case "Diamond" -> colorCount[1]++;
            case "Spade" -> colorCount[2]++;
            case "Club" -> colorCount[3]++;
        }
      //https://www.data-transitionnumerique.com/java-switch-case/
    } 
    
    // Transmettre les données à WhatCombinaison
    WhatCombinaison whatCombinaison = new WhatCombinaison(occurrences, colorCount);
    
    System.out.println("Analyzing hand for player: " + player.getName());
    Combinaison result = whatCombinaison.getBestCombinaison();
    System.out.println("Best combination: " + result);
    
    // Debug output
    // for (int i = 0; i < occurrences.length; i++) {
    //     if (occurrences[i] > 0) {
    //         System.out.println("Occurrences of value " + i + ": " + occurrences[i]);
    //     }
    // }
    
    // String[] colorNames = {"Heart", "Diamond", "Spade", "Club"};
    // for (int i = 0; i < colorCount.length; i++) {
    //     System.out.println("Occurrences of color " + colorNames[i] + ": " + colorCount[i]);
    // }
    
    return result;
  }

  // Recuperer la main du joueur

  //Stocker le resultat 
  
  //Comparer les combinaisons des joueurs pour determiner le gagnant


} 
