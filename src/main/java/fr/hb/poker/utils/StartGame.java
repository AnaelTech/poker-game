package fr.hb.poker.utils;

import java.util.ArrayList;
import java.util.Scanner;

import fr.hb.poker.business.Player;

public class StartGame {
    
     private static Scanner scanner = new Scanner(System.in);
     private static ArrayList<Player> players = new ArrayList<>();

    public void Start() {
        System.out.println("♠ Welcome to Poker Game ♠");
        int numberOfPlayers;
        
        while (true) {
            System.out.print("Enter the number of players (2 to 10): ");
            if (scanner.hasNextInt()) {
                numberOfPlayers = scanner.nextInt();
                scanner.nextLine(); 
                if (numberOfPlayers >= 2 && numberOfPlayers <= 10) {
                    break;
                } else {
                    System.out.println("❌ Please enter a number between 2 and 10.");
                }
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        CardManagement cardManagement = new CardManagement(players);
        cardManagement.startGame();

        // Show each player's hand
        for (Player player : players) {
            System.out.println("\n🧍 " + player.getName() + "'s hand:");
            player.getHand().forEach(card -> System.out.println("  - " + card));
            cardManagement.analyseHand(player);
        }

        scanner.close();
  }
}
