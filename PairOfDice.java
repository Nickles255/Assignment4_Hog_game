/**
  * PairOfDice consists of two Die objects from the
  * die class.
  * functionality includes get and set both die.
  * sum and roll die and a toString method.
  *  @author(s) Chien Lin, Lena Zheng, Qd Li
  *  @version 1.0
  *  @since 2017-10-15 
  *
  */

public class PairOfDice {
  private Die die1 = new Die();
  private Die die2 = new Die();
  private int currentTotal;
  
  public PairOfDice() {
    currentTotal = 2;
	die1.setFaceValue(1);
	die2.setFaceValue(1);
  }

  public Die getDie1() {
    return die1;
  }

  public Die getDie2(){
    return die2;
  }

  public void setDie1(int value){
    currentTotal = currentTotal - die1.getFaceValue();   
    die1.setFaceValue(value);  
    currentTotal = currentTotal + die1.getFaceValue();
  }
  
  public void setDie2(int value){
    currentTotal = currentTotal - die2.getFaceValue();   
    die2.setFaceValue(value);  
    currentTotal = currentTotal + die2.getFaceValue();
  }
  
  // return sum of dice
  public int sumDice() {
    return currentTotal; 
  }  
 
 // will return sum of roll
  public int rollDice() {
    die1.roll();
    die2.roll();
    currentTotal = die1.getFaceValue() + die2.getFaceValue();
    return currentTotal;
  }  
  
// Returns string representation of sum of roll  
  public String toString() {
      String result = "Die1: " + die1.getFaceValue() + 
                      "; Die2: " + die2.getFaceValue(); 
      return result;
  }
}
