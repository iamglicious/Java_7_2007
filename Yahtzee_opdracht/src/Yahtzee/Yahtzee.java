package Yahtzee;

import java.util.*;
public class Yahtzee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/**
 * Yahtzee met 5 dobbelstenen en score bijhouden
 */


    int play = 1, scorea = 0, sum = 0;
    int[] wins = new int[15];
    while ((play == 1) && (sum < 15)) {
      sum = 0;
      int[] aDice = new int[] { 0, 0, 0, 0, 0 };// maakt een array
      int roll = 0;
      int x, y, w, z;
      int rerolla = 0, rerollb = 03;
      Die die = new Die();
      for (x = 0; x < 5; x++) {
        die.roll();
        aDice[x] = die.get();// zet de dobbelsteen waarde
      }
 
      System.out.println("Die 1: " + aDice[0]);
      System.out.println("Die 2: " + aDice[1]);
      System.out.println("Die 3: " + aDice[2]);
      System.out.println("Die 4: " + aDice[3]);
      System.out.println("Die 5: " + aDice[4]);
 
      do {
        rerolla = inputInt("Hoeveel dobbelstenen op nieuw gooien? (0-5)");
        if (rerolla > 0) {
          int[] reroll = new int[rerolla];
          for (y = 0; y < rerolla; y++) {
            rerollb = inputInt("Welke dobbelstenen?");
            reroll[y] = rerollb;
          }
          for (w = 0; w < rerolla; w++) {
            if (reroll[w] == 1) {
              die.roll();
              aDice[0] = die.get();
            }
            if (reroll[w] == 2) {
              die.roll();
              aDice[1] = die.get();
            }
            if (reroll[w] == 3) {
              die.roll();
              aDice[2] = die.get();
            }
            if (reroll[w] == 4) {
              die.roll();
              aDice[3] = die.get();
            }
            if (reroll[w] == 5) {
              die.roll();
              aDice[4] = die.get();
            }
          }
          roll++;
          System.out.println("Dobbelsteen 1: " + aDice[0]);
          System.out.println("Dobbelsteen 2: " + aDice[1]);
          System.out.println("Dobbelsteen 3: " + aDice[2]);
          System.out.println("Dobbelsteen 4: " + aDice[3]);
          System.out.println("Dobbelsteen 5: " + aDice[4]);
 
        }
      } while ((roll < 2) && (rerolla > 0));
      Winnings prize = new Winnings();
      prize.checkWinnings(aDice, wins);
      wins[prize.choice() - 1] = 1;
      for (z = 0; z < 15; z++) {
        sum += wins[z];
      }
      scorea += prize.score();
      System.out.println("Totale score is: " + scorea);
      if (sum < 15) {
        play = inputInt("Wil je opnieuw spelen ?(1=Ja, 2=Nee)");
      } else {
        System.out.println("GAME OVER!");
      }
    }
  }
 
  static int inputInt(String Prompt) {
    int result = 0;
    try {
      result = Integer.parseInt(input(Prompt).trim());
    } catch (Exception e) {
      result = 0;
    }
    return result;
  }
 
  static String input(String prompt) {
    String inputLine = "";
    System.out.print(prompt);
    try {
      java.io.InputStreamReader sys = new java.io.InputStreamReader(
          System.in);
      java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
      inputLine = inBuffer.readLine();
    } catch (Exception e) {
      String err = e.toString();
      System.out.println(err);
    }
    return inputLine;
  }
}//test toevoeging
