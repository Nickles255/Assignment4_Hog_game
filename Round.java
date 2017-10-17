/**
  * Round.java class to represent round of a game.
  * accessors include getPlayer, getRoundSCore, getPotentialTotal, getStopInd.
  * write methods include addRoundScore, setStopInd
  * tostring method returns results of current round.
  *  @author(s) Chien Lin, Lena Zheng, Qd Li
  *  @version 1.0
  *  @since 2017-10-15 
  *  Represents the round of rolling the pair of dies
*/
public class Round
{
    String currentPlayer;
    int totalScore, roundScore = 0;
    boolean stopInd = false;

    //-----------------------------------------------------------------
    //  Constructor: for each round of the game
    //-----------------------------------------------------------------
    public Round(String player, int inTotalScore)
        {
        currentPlayer = player;
        totalScore = inTotalScore;
        }

    public String getPlayer()
        {return currentPlayer;}

    //takes in the score from PairOfDice and addes it to roundScore and totalScore
    public void addRoundScore(int sumDice)
        {roundScore += sumDice;
        totalScore += sumDice;
		    }

    public int getRoundScore()
        {return roundScore;}

    public int getPotentialTotal()
        {return totalScore;}

    //gets stop indicator to know when the round is over
    public boolean getStopInd()
        {return stopInd;}

    //Set the stop indicator
    public void setStopInd(boolean indicator)
        {stopInd = indicator;}

    // Returns string printing potential_total and round_total  
    public String toString() 
        {String result = "Current Round: " + roundScore + "\n" + 
                        "Potential Total: " + totalScore; 
        return result;}
}
