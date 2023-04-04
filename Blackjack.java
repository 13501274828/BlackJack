package edu.nyu.cs;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    // complete this function according to the instructions
    System.out.println("Welcome to Blackjack!");
    ArrayList<Integer> userTotal = new ArrayList<>();
    userTotal.add((int)(Math.random()*11 + 1));
    userTotal.add((int)(Math.random()*11 + 1));
    Scanner scrn = new Scanner(System.in);
    boolean keepGoing = true;

    while(keepGoing){
      System.out.println("Your cards are: " + holdingCards(userTotal));
      System.out.println("Would you like to hit or stand? ");
      String decision = scrn.nextLine();

      if(decision.equals("hit")){
        userTotal.add((int)(Math.random()*11 + 1));
        if(Busts(userTotal)){
          keepGoing = false;
        }
      }
      else if(decision.equals("stop") || decision.equals("stand") || decision.equals("pass")){
        keepGoing = false;
      }
    }
    ArrayList<Integer> dealerTotal = new ArrayList<>();
      dealerTotal.add((int)(Math.random()*11 + 1));
      dealerTotal.add((int)(Math.random()*11 + 1));

    if(Busts(userTotal)){
      System.out.println("Your cards are: " + holdingCards(userTotal));
      System.out.println("You have bust!");
      System.out.println("Dealer wins!");
    }

    else {
      while( (int)(Math.random() * 2) < 1  ){
        System.out.println("The dealer hits.");
        dealerTotal.add((int)(Math.random()*11 + 1));
      }
      System.out.println("The dealer stands.");

      if(Busts(dealerTotal)){
        System.out.println("Your cards are: " + holdingCards(userTotal));
        System.out.println("The dealer's cards are: " + holdingCards(dealerTotal));
        System.out.println("The dealer has bust!");
        System.out.println("You win!");
      }

      else if(getSum(dealerTotal) < getSum(userTotal)){
        System.out.println("Your cards are: " + holdingCards(userTotal));
        System.out.println("The dealer's cards are: " + holdingCards(dealerTotal));
        System.out.println("You win!");
      }

      else if (getSum(dealerTotal) > getSum(userTotal)){
        System.out.println("Your cards are: " + holdingCards(userTotal));
        System.out.println("The dealer's cards are: " + holdingCards(dealerTotal));
        System.out.println("Dealer wins!");
      }
      else if(getSum(dealerTotal) == getSum(userTotal)){
        System.out.println("Your cards are: " + holdingCards(userTotal));
        System.out.println("The dealer's cards are: " + holdingCards(dealerTotal));
        System.out.println("Tie!");
      }
    }
    

    scrn.close();
  } // main



public static String holdingCards(ArrayList<Integer> cardsList){
  if(cardsList.size() == 2){
    return Integer.toString(cardsList.get(0)) + " and " + Integer.toString(cardsList.get(1));
  }
  else{
    String connectionOfCard = "";
    for(int i = 0; i<cardsList.size()-1; i++){
      connectionOfCard = connectionOfCard + Integer.toString(cardsList.get(i)) + ", ";
    }
    connectionOfCard = connectionOfCard + "and " + Integer.toString(cardsList.get(cardsList.size()-1));
    return connectionOfCard;
  }
}


public static boolean Busts(ArrayList<Integer> testBustList){
  if(getSum(testBustList) > 21){
    return true;
  }
  else{
    return false;
  }
}

public static int getSum(ArrayList<Integer> addingList){
  int listSum = 0;
  for(int i = 0; i<addingList.size(); i++){
    listSum = listSum + addingList.get(i).intValue();
  }
  return listSum;
}

}
