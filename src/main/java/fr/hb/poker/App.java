package fr.hb.poker;

import java.util.List;

import fr.hb.poker.business.Town;
import fr.hb.poker.utils.ReadCSV;
import fr.hb.poker.utils.SearchTown;

public class App 
{
    public static void main( String[] args )
    {
        //  StartGame startGame = new StartGame();
        //  startGame.Start();
        // 
        ReadCSV readCSV = new ReadCSV();
        List<Town> towns = readCSV.getTowns(); // Récupère les villes

        SearchTown searchTown = new SearchTown(towns);

        searchTown.search();
          
        // Town town = new Town("Paris", "75000", "75101", 48.8566, 2.3522);
        //
        // Player player = new Player("John Doe", 100.0f, LocalDate.of(1990, 1, 1), LocalDateTime.now(), town);
        // System.out.println(player);
        
      
    }
} 
