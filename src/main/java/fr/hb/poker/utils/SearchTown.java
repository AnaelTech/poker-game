package fr.hb.poker.utils;

import java.util.List;
import java.util.Scanner;

import fr.hb.poker.business.Town;

public class SearchTown {
    
    private List<Town> towns;
    
    Scanner scanner;

    public SearchTown(List<Town> towns) {
        this.towns = towns;
        this.scanner = new Scanner(System.in);
    }
    
    public void search()
    { 
      System.out.print("Searching for town: ");
      String name = scanner.nextLine().toUpperCase();
      System.out.println("Searching for town: " + name);
     
      for (Town town : towns) {
          if (town.getName().equalsIgnoreCase(name)) {
              System.out.println("Found town: " + town.getName() + " " + town.getZipCode() + " in " + 
                                 " at coordinates: " + town.getLatitude() + ", " + town.getLongitude());
              return;
          }
            else if (town.getName().contains(name)){
            System.out.println("Found town: " + town.getName() + " " + town.getZipCode() + " in " + 
                                 " at coordinates: " + town.getLatitude() + ", " + town.getLongitude());
      }
          
      }
      System.out.println("Town not found: " + name);
    }      
}
