package fr.hb.poker.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.hb.poker.business.Town;

public class ReadCSV {

  private List<Town> towns = new ArrayList<>();

  public List<Town> getTowns() {
      return towns;
  }


  public ReadCSV() {
    read();
     
  }


  public void read() {  
    try {
      List<String> lignes = Files.readAllLines(Paths.get("communes-departement-region.csv"));
            lignes.remove(0); 
      for (String ligne : lignes) {
          String[] parts = ligne.split(",");
         
        if(!parts[5].isEmpty() && !parts[6].isEmpty()) {
          Town town = createTownsFromCSV(parts);
          towns.add(town);
        } 
      }
      System.out.println("Town created");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
  }

  public Town createTownsFromCSV(String[] parts) {
        
    Town town = new Town(parts[4], parts[2], parts[0], 
                         Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
    return town;
  }
}



