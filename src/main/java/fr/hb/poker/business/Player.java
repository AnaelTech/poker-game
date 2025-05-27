package fr.hb.poker.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Player {

private Long id;
private String name;
private float solde;
private LocalDate birthdayDay;
private LocalDateTime dateInscription;
private ArrayList<Card> hand = new ArrayList<>();
private static Long counter = 0L; //Variable de classe le static 

public Player(String name) {
    id = ++counter;
    this.name = name;
  }


public Player(Long id, String name, float solde, LocalDate birthdayDay, LocalDateTime dateInscription) {
    this.id = id;
    this.name = name;
    this.solde = solde;
    this.birthdayDay = birthdayDay;
    this.dateInscription = dateInscription;
  }

public Long getId(){
    return id;
  }

public void setId(Long id){
    this.id = id;
} 

public String getName(){
    return name;
  }

public void setName(String name){
    this.name = name;
  }

public float getSolde(){
    return solde;
  }

public void setSolde(float solde){
    this.solde = solde;
  }

public LocalDate getBirthdayDay(){
    return birthdayDay;
  }

public LocalDateTime getDateInscription(){
    return dateInscription;
  }

public void setDateInscription(LocalDateTime dateInscription){
    this.dateInscription = dateInscription;
  }

public ArrayList<Card> getHand() {
    return hand;
  }

public void setHand(ArrayList<Card> hand) {
    this.hand = hand;
  }
}
