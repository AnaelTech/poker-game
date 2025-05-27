package fr.hb.poker.utils;

import fr.hb.poker.business.Combinaison;

public class WhatCombinaison {

 private int[] occurrences; // Index 0 unused, 2-14 for card values
 private int[] colorCount; // Index 0-3 for Hearts, Diamonds, Spades, Clubs
    
// CARTE_HAUTE,
// PAIRE,
// DOUBLE_PAIRE,
// BRELAN,
// SUITE,
// COULEUR,
// FULL,
// CARRE,
// QUINTE_FLUSH,
// QUINTE_FLUSH_ROYALE

 // Case si main du joueur égale a 10-Valet-Dame-Roi-As et qu'ils ont la meme couleur alors il a une quite flush royale
 // Si main du joueur égale a  As-Roi-Dame-Valet-10 et qu'ils ont la meme couleur alors il a une quite flush royale
    
    // Case si chiffre se suit et de la meme couleur quinte flush
    
    // Case si 4 cartes de meme valeur alors il a un carré
    
    // Case son 3 cartes de meme valeur alors il a un brelan
    
    // Case si 2 cartes de meme valeur alors il a une paire
    
    // Case si 2 cartes de meme valeur et 2 autres cartes de meme valeur alors il a un double paire
    
    // Case si 5 cartes de meme couleur alors il a une Couleur
    
    // Case si 5 cartes se suivent alors il a une Quinte
    
    // Case si carte la plus haute alors il a une carte haute


public WhatCombinaison(int[] occurrences, int[] colorCount) {
    this.occurrences = occurrences;
    this.colorCount = colorCount;
  }
    
     public Combinaison getBestCombinaison() {
    if (isQuinteFlushRoyale()){return Combinaison.QUINTE_FLUSH_ROYALE;}
    if (isCarre()){return Combinaison.CARRE;}
    if (isFull()){return Combinaison.FULL;}
    if (isCouleur()){return Combinaison.COULEUR;}
    if (isSuite()){return Combinaison.SUITE;}
    if (isBrelan()){return Combinaison.BRELAN;}
    if (isTwoPair()){return Combinaison.DOUBLE_PAIRE;}
    if (isPair()){return Combinaison.PAIRE;}
    return Combinaison.CARTE_HAUTE;
}



  public boolean isPair() {
     for (int i = 2; i < occurrences.length; i++) {
      if (occurrences[i] == 2) {
        System.out.println("Paire found with value: " + i);
        return true;
      }
    }
    return false;
  }

  
  public boolean isTwoPair() {
    int pairs = 0;
    for (int i = 2; i < occurrences.length; i++) {
        if (occurrences[i] == 2) pairs++;
    }
    return pairs >= 2;
  }

  public boolean isCarteHaute(){
    for (int i = 2; i < occurrences.length; i++) {
      if (occurrences[i] > 0) {
        System.out.println("Carte Haute found with value: " + i);
        return true;
      }
    }
    return false;
  }

  public boolean isBrelan() {
    for (int i = 2; i < occurrences.length; i++) {
      if (occurrences[i] == 3) {
        System.out.println("Brelan found with value: " + i);
        return true;
      }
    }
    return false;
  }

  public boolean isQuinte() {
    for (int i = 2; i < occurrences.length - 4; i++) {
      //Vérification de 5 cartes consécutives
      if (occurrences[i] > 0 && occurrences[i + 1] > 0 && occurrences[i + 2] > 0 && occurrences[i + 3] > 0 && occurrences[i + 4] > 0) {
        System.out.println("Quinte found starting with value: " + i);
        return true;
      }
    }
   return false;
  }

  public boolean isCouleur() {
    for (int count : colorCount) {
        if (count >= 5) {
            System.out.println("Flush found.");
            return true;
        }
    }
    return false;
  }

  public boolean isFull() {
    for (int i = 2; i < occurrences.length; i++) {
      if (occurrences[i] == 3) {
        for (int j = 2; j < occurrences.length; j++) {
          if (occurrences[j] == 2 && i != j) {
            System.out.println("Full found with triplet: " + i + " and pair: " + j);
            return true;
          }
        }
      }
    }
    return false;
    
  }

  public boolean isCarre() {
    for (int i = 2; i < occurrences.length; i++) {
      if (occurrences[i] == 4) {
        System.out.println("Carre found with value: " + i);
        return true;
      }
    }
    return false;
  }

  public boolean isQuinteFlushRoyale() {
     if (!isCouleur()) return false;

    // Check for 10-J-Q-K-A
    for (int i = 10; i <= 14; i++) {
        if (occurrences[i] == 0) return false;
    }

    System.out.println("Quinte Flush Royale found!");
    return true; 
  }
  
  

  public boolean isSuite(){
    for (int i = 2; i < occurrences.length - 4; i++) {
      if (occurrences[i] > 0 && occurrences[i + 1] > 0 && occurrences[i + 2] > 0 && occurrences[i + 3] > 0 && occurrences[i + 4] > 0) {
        System.out.println("Suite found starting with value: " + i);
        return true;
      }
    }
    return false;
  }




}
