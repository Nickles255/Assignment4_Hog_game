/**
  * RollingDie2 is the driver class which tests PairOfDie class 
  * PairOfDie functionality includes
  * get and set both die.
  * sum and roll die and a toString method.
  *  @author(s) Chien Lin, Lena Zheng, Qd Li
  *  @version 1.0
  *  @since 2017-10-04 
  *   
  */

public class RollingDice2 {
  public static void main(String[] args){

    PairOfDie OnePair = new PairOfDie();


    System.out.println("\nValue of Initialized Dice");
    System.out.println("First Dice: " + OnePair.getDie1());
    System.out.println("Second Dice: " + OnePair.getDie2());

    OnePair.setDie2(5);
    OnePair.setDie1(3);

    System.out.println("\nSetting Dice to 3 and 5");
    System.out.println("\nFirst Dice: " + OnePair.getDie1());
    System.out.println("Second Dice: " + OnePair.getDie2());
    System.out.println("Sum of Dice: " + OnePair.sumDice());      

    OnePair.rollDice();

    System.out.println("\nRolling the Dice");
    System.out.println("\nFirst Dice: " + OnePair.getDie1());
    System.out.println("Second Dice: " + OnePair.getDie2());
    System.out.println("Sum of Dice: " + OnePair.sumDice());      

    System.out.println("To String return: " + OnePair.toString());


  }   
 
}
