package yahtzee;

import java.util.Random;

/* Opgooien van dobbelsteen */
public class Dobbelsteen {
  private int value;
  private Random rand;
 
  public Dobbelsteen() {
    value = 0;
    rand = new Random();
  }
 
  public void rollen() {
    value = 1 + rand.nextInt(6);
  }
 
  public int get() {
    return (value);
  }
}