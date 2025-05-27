package fr.hb.poker.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import fr.hb.poker.business.Town;

public class ReadCSV {

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
          createTownsFromCSV(parts);
        } 
      }
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
  }

  public void createTownsFromCSV(String[] parts) {
        
    Town town = new Town(parts[1], parts[2], parts[0], 
                         Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));

    System.out.println("Town created: " + town.getName() + 
                       ", ZipCode: " + town.getZipCode() + 
                       ", CodeInsee: " + town.getCodeInsee() + 
                       ", Latitude: " + town.getLatitude() + 
                       ", Longitude: " + town.getLongitude());
  }
}



