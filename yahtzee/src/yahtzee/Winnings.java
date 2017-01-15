package yahtzee;

import java.util.Arrays;

public class Winnings {
  private int score;
  private int choice;
 
  public Winnings() {
    score = 0;
  }
 
  public void checkWinnings(int[] aDice, int[] wins) {
    System.out.println("Wat wil je controleren ?");
    if (wins[0] == 0) {
      System.out.println("1 - yahtzee");
    }
    if (wins[1] == 0) {
      System.out.println("2 - full house");
    }
    if (wins[2] == 0) {
      System.out.println("3 - grote straat");
    }
    if (wins[3] == 0) {
      System.out.println("4 - kleine straat");
    }
    if (wins[4] == 0) {
      System.out.println("5 - 4 gelijke");
    }
    if (wins[5] == 0) {
      System.out.println("6 - drie gelijke");
    }
    if (wins[6] == 0) {
      System.out.println("7 - paar");
    }
    if (wins[7] == 0) {
      System.out.println("8 - twee paar");
    }
    if (wins[8] == 0) {
      System.out.println("9 - nummer of 1's");
    }
    if (wins[9] == 0) {
      System.out.println("10 - nummer of 2's");
    }
    if (wins[10] == 0) {
      System.out.println("11 - nummer of 3's");
    }
    if (wins[11] == 0) {
      System.out.println("12 - nummer of 4's");
    }
    if (wins[12] == 0) {
      System.out.println("13 - nummer of 5's");
    }
    if (wins[13] == 0) {
      System.out.println("14 - nummer of 6's");
    }
    if (wins[14] == 0) {
      System.out.println("15 - kans");
    }
    choice = yahtzee.inputInt("");
 
    int x = 0, y = 0, winings = 0, winingsa = 0;
    int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
    Arrays.sort(aDice);
 
    //Nummers
    for (y = 0; y < 5; y++) {
      if (aDice[y] == 1) {
        ones++;
      }
      if (aDice[y] == 2) {
        twos++;
      }
      if (aDice[y] == 3) {
        threes++;
      }
      if (aDice[y] == 4) {
        fours++;
      }
      if (aDice[y] == 5) {
        fives++;
      }
      if (aDice[y] == 6) {
        sixes++;
      }
    }
 
    //Straat
    if ((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1)
        && (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1)
        && (choice == 3)) {
      winingsa = 1;
    } else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) {
      winingsa = 2;
    } else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
      winingsa = 2;
    } else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) {
      winingsa = 2;
    }
 
    //Paren
    for (x = 0; x < 5; x++) {
      if (x != 0) {
        if ((aDice[0] == aDice[x])) {
          winings++;
        }
      }
      if ((x != 0) && (x != 1)) {
        if ((aDice[1] == aDice[x])) {
          winings++;
        }
      }
      if ((x != 0) && (x != 1) && (x != 2)) {
        if ((aDice[2] == aDice[x])) {
          winings++;
        }
      }
      if ((x != 0) && (x != 1) && (x != 2) && (x != 3)) {
        if ((aDice[3] == aDice[x])) {
          winings++;
        }
      }
    }
 
    //winpunten
    if ((winingsa == 1) && (choice == 3)) {
      System.out.println("je hebt een straat.");
      score = 40;
    } else if ((winingsa == 2) && (choice == 4)) {
      System.out.println("je hebt een kleine straat.");
      score = 30;
    } else if ((winings == 10) && (choice == 1)) {
      System.out.println("Yatzee!");
      score = 50;
    } else if ((choice == 6) && (winings >= 3)) {
      System.out.println("je hebt drie gelijke.");
      score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
    } else if ((choice == 7) && (winings > 0)) {
      System.out.println(" je hebt een paar.");
      score = 5;
    } else if ((winings == 2) && (choice == 8)) {
      System.out.println("je hebt 2 paar.");
      score = 10;
    } else if ((winings == 4) && (choice == 2)) {
      System.out.println("je hebt een full house.");
      score = 25;
    } else if ((winings >= 6) && (choice == 5)) {
      System.out.println("je hebt 4 gelijke.");
      score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
    } else if (choice == 9) {
      System.out.println("je hebt " + ones + " eenen.");
      score = ones;
    } else if (choice == 10) {
      System.out.println("je hebt " + twos + " tweeen.");
      score = twos * 2;
    } else if (choice == 11) {
      System.out.println("je hebt " + threes + " drieen.");
      score = threes * 3;
    } else if (choice == 12) {
      System.out.println("je hebt " + fours + " vieren.");
      score = fours * 4;
    } else if (choice == 13) {
      System.out.println("je hebt " + fives + " vijfen.");
      score = fives * 5;
    } else if (choice == 14) {
      System.out.println("je hebt " + sixes + " zessen.");
      score = sixes * 6;
    } else if (choice == 15) {
      score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
      System.out.println("je hebt " + score + " punten.");
    } else {
      System.out.println("je hebt niets'.");
      score = 0;
    }
  }
 
  public int score() {
    return (score);
  }
 
  public int choice() {
    return (choice);
  }
}