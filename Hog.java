/**
  * Hog is the driver class. It depends on PairOfDie class
  * to manipulate die and Round class to store round values.
  * Hog is a game played between a human and a computer
  * specific details of the game in described in the algorithm below.
  *  @author(s) Chien Lin, Lena Zheng, Qd Li
  *  @version 2.0
  *  @since 2017-10-15
  *
  */
/**
  * Algorithm:
  *   a. initializes PairofDice object, Scanner object 
  *      humanTotalScore, ComputerTotalScore, curRound 
  *      prints initial score 
  *   b. outer while loop check if results of round ends the game.
  *      exit if (comp >= 50 or human >= 50) 
  *      creates a round object 
  *   c. inner while loop checks if stop round indicator = 'Y' 
  *      exit if (either die = 1 or human selects no or computer round score >= 20)  
  *      determine player for the round and then initializes round object
  *   d. inside code rolls dice, determine if round should continue and adds scores 
  *   e. once outer while loop is exited. print final score and declare winner 
  *
 */
import java.util.Scanner;

public class Hog {
	
  public static void main(String[] args){
//Step a. Initializing values
    int curRound = 1;
    String curPlayer = "Computer";
    int computerTotalScore = 0;
    int humanTotalScore = 0;
    char human_cont = 'y';
    Scanner scan = new Scanner(System.in);
    PairOfDie diePair = new PairOfDie();
    Round myRound;
         
// Step b. outer while loop controls the game results
    while (computerTotalScore < 50 && humanTotalScore < 50){
        
      //printout related to round and status of game
      System.out.println("*************************************");
      System.out.println("Current Status in Round " + curRound + ":");

      curPlayer = (curRound%2 == 1 ? "Computer" : "Human");
      if (curPlayer == "Computer") {
          myRound = new Round(curPlayer, computerTotalScore); 
      }	else {myRound = new  Round(curPlayer, humanTotalScore);}      
     
      System.out.println("Current player is: " + curPlayer);
      System.out.println();
      System.out.println("Computer: " + computerTotalScore);
      System.out.println("You: " + humanTotalScore + "\n");

// Step c. inner while loop controls round results
      while(myRound.getStopInd() == false){

// Step d. roll die at beginning of round
        diePair.rollDice();
        System.out.println(diePair.toString());
        System.out.println();     

        // end round if either die was 1.
        if(diePair.getDie1() == 1 || diePair.getDie2() == 1){
           myRound.setStopInd(true);
           System.out.println("Busted!\n");
        // pause game for 250 milliseconds
           try {Thread.sleep(250);
           } catch (Exception e) {}

       }

        // if round continues add score to total and then 
        // determines if round should continue
        // according to criteria depending on type of player.
        if(myRound.getStopInd() == false){
             myRound.addRoundScore(diePair.sumDice());
             System.out.println("Round Score: " + myRound.getRoundScore());
             System.out.println("Potential Score: " + myRound.getPotentialTotal());
             System.out.println("\n");

             if(myRound.getPlayer() == "Human" && myRound.getPotentialTotal() < 50){
                  System.out.println("Take another turn (y/n)?");
                  human_cont = scan.next().charAt(0);
             }
       

             if((myRound.getPlayer() == "Human" && human_cont == 'n') || 
                 myRound.getPotentialTotal() >= 50) {
                  humanTotalScore = myRound.getPotentialTotal();
                  myRound.setStopInd(true);
             } else {if((myRound.getPlayer() == "Computer" && myRound.getRoundScore() >= 20) || 
                         myRound.getPotentialTotal() >= 50) {
                                 computerTotalScore = myRound.getPotentialTotal();
                                 myRound.setStopInd(true);
                     }
             }
        
        }

      }
      // pause game for 300 milliseconds
      try {Thread.sleep(300);
      } catch (Exception e) {}

      curRound += 1;

    } 

// Step e. final determination of winner.
    System.out.println("The " + curPlayer + " has won!");
    System.out.println("Final Results:\n");
    System.out.println("Computer: " + computerTotalScore);
    System.out.println("You: " + humanTotalScore + "\n");


  }

}
 