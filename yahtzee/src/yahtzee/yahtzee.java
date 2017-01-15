package yahtzee;
 
/**
 * Yahtzee met 5 dobbelstenen
 */
public class yahtzee {
  public static void main(String[] args) {
    int play = 1, scorea = 0, sum = 0;
    int[] wins = new int[15];
    while ((play == 1) && (sum < 15)) {
      sum = 0;
      int[] aDobbel = new int[] { 0, 0, 0, 0, 0 };// maakt een array
      int roll = 0;
      int x, y, w, z;
      int opnieuwrollen = 0, opnieuwrollena = 03;
      Dobbelsteen dobbel = new Dobbelsteen();
      for (x = 0; x < 5; x++) {
        dobbel.rollen();
        aDobbel[x] = dobbel.get();// zet de dobbelsteen waarde in array
      }
 // printen van de dobbelstenem
      System.out.println("Dobbelsteen 1: " + aDobbel[0]);
      System.out.println("Dobbelsteen 2: " + aDobbel[1]);
      System.out.println("Dobbelsteen 3: " + aDobbel[2]);
      System.out.println("Dobbelsteen 4: " + aDobbel[3]);
      System.out.println("Dobbelsteen 5: " + aDobbel[4]);
 
      do {
    	  opnieuwrollen = inputInt("Hoeveel dobbelstenen op nieuw gooien? (0-5)"); // hoeveel opnieuw gooien
        if (opnieuwrollen > 0) {
          int[] reroll = new int[opnieuwrollen];
          for (y = 0; y < opnieuwrollen; y++) {
        	  opnieuwrollena = inputInt("Welke dobbelstenen?"); // kies welke dobbelsteen opnieuw gooien
            reroll[y] = opnieuwrollena;
          }
          for (w = 0; w < opnieuwrollen; w++) {
            if (reroll[w] == 1) {
              dobbel.rollen();
              aDobbel[0] = dobbel.get();
            }
            if (reroll[w] == 2) {
            	dobbel.rollen();
              aDobbel[1] = dobbel.get();
            }
            if (reroll[w] == 3) {
            	dobbel.rollen();
              aDobbel[2] = dobbel.get();
            }
            if (reroll[w] == 4) {
            	dobbel.rollen();
              aDobbel[3] = dobbel.get();
            }
            if (reroll[w] == 5) {
            	dobbel.rollen();
              aDobbel[4] = dobbel.get();
            }
          }
          roll++; // print nieuwe waardes van dobbelstenen
          System.out.println("Dobbelsteen 1: " + aDobbel[0]);
          System.out.println("Dobbelsteen 2: " + aDobbel[1]);
          System.out.println("Dobbelsteen 3: " + aDobbel[2]);
          System.out.println("Dobbelsteen 4: " + aDobbel[3]);
          System.out.println("Dobbelsteen 5: " + aDobbel[4]);
 
        }
      } while ((roll < 2) && (opnieuwrollen > 0)); 
      Winnings prize = new Winnings();
      prize.checkWinnings(aDobbel, wins); // controleer uitkomst
      wins[prize.choice() - 1] = 1;
      for (z = 0; z < 15; z++) {
        sum += wins[z];
      }
      scorea += prize.score();
      System.out.println("Totale score is: " + scorea); //print score uit
      if (sum < 15) {
        play = inputInt("Wil je opnieuw spelen ?(1=Ja, 2=Nee)");// keuze opnieuw spelen
      } else {
        System.out.println("GAME OVER!");
      }
    }
  }
 // exception bij niet opnieuw gooien direct naar resultaat
  static int inputInt(String Prompt) {
    int result = 0;
    try {
      result = Integer.parseInt(input(Prompt).trim());
    } catch (Exception e) {
      result = 0;
    }
    return result;
  }
 // exception in bouwen bij verkeerde ingave
  
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
}