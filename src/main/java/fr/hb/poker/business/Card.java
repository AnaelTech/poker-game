package fr.hb.poker.business;


public class Card {

private String name;
private int value;
private Color color;

public Card(int value, Color color) {
    
    switch (value) {
      case 11:
        this.name = "Jack";
        break;
      case 12:
        this.name = "Queen";
        break;
      case 13:
        this.name = "King";
        break;
      case 14:
        this.name = "Ace";
        break;
      default:
        this.name = String.valueOf(value);
    }

    this.value = value;
    this.color = color;
  }

public String getName() {
    return name;
  }

public void setName(String name) {
    this.name = name;
  }

public int getValue() {
    return value;
  }

public void setValue(int value) {
    this.value = value;
  }

public Color getColor() {
    return color;
  }

public void setColor(Color color) {
    this.color = color;
  }

public String toString() {
    return name + " of " + color.getName();
  }

}
