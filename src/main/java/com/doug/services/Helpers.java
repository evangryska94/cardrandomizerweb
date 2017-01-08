package com.doug.services;

import com.doug.domain.Card;
import com.doug.domain.Test;

import java.util.ArrayList;

/**
 * Created by Doug on 12/19/16.
 */
public abstract class Helpers {
//	public ArrayList<Card> cachedCards = new ArrayList<Card>();

	public static ArrayList<Card> Score(ArrayList<Card> masterDeck, ArrayList<Card> quickAnswers){
		ArrayList scoresArray = new ArrayList();

		for(int i=0;i<quickAnswers.size();i++){
			if(masterDeck.get(i).getCardName().equals(quickAnswers.get(i).getCardName())) {
				scoresArray.add(true);
				System.out.println("Found equal on number " + i + " - " + masterDeck.get(i).getCardName() + " = " + quickAnswers.get(i).getCardName());
			} else {

				scoresArray.add(false);
				System.out.println("Found not equal on number " + i + " - " + masterDeck.get(i).getCardName() + " != " +
						  quickAnswers.get(i).getCardName());
			}
		}
		return scoresArray;



	}

	public static String ResolveAnswers(String cardEntry) {
		String firstChar;
		String cardName;
		String suit = "";
		String suitCode = "";

		firstChar = ((String) cardEntry.substring(0,1));
		suitCode = ((String) cardEntry.substring(1,2));

		//Get cardName
		switch (firstChar) {
			case "a":
				cardName = "Ace";
				break;
			case "j":
				cardName = "Jack";
				break;
			case "k":
				cardName = "King";
				break;
			case "q":
				cardName = "Queen";
				break;
			case "1":
				cardName = "10";
				break;
			default:
				cardName = firstChar;
				break;
		}

		//Get suit
		switch (suitCode) {
			case "s":
				suit = "Spades";
				break;
			case "h":
				suit = "Hearts";
				break;
			case "c":
				suit = "Clubs";
				break;
			case "d":
				suit = "Diamonds";
				break;
			default:
				suit=null;
				break;
		}


		return (cardName + "_of_" + suit);

	}

	public static ArrayList SimpleCompareArrays(ArrayList<Card> masterDeck, ArrayList<Card> answerDeck) {
		ArrayList<Test> scoresArray = new ArrayList();
		Test test;
		Double finalScore=0.00;

		for(int i=0;i<masterDeck.size();i++){
			test = new Test();
			test.setId(i);
			test.setMasterCardName(masterDeck.get(i).getCardName());
			test.setAnswerCardName(answerDeck.get(i).getCardName());

			if(masterDeck.get(i).getCardName().equals(answerDeck.get(i).getCardName())) {
				test.setScore(true);
				finalScore = finalScore+1;
				System.out.println("Found equal on number " + i + " - " + masterDeck.get(i).getCardName() + " = " + answerDeck.get(i).getCardName());
			} else {
				test.setScore(false);
				System.out.println("Found not equal on number " + i + " - " + masterDeck.get(i).getCardName() + " != " +
						  answerDeck.get(i).getCardName());
			}
			scoresArray.add(i, test);
		}

		return scoresArray;


	}

	public static String CalcFinalScore(ArrayList<Test> testArray) {
		Double finalScore = 0.0;

		for(int i = 0; i< testArray.size(); i++) {
			if(testArray.get(i).isTest()) {
				finalScore = finalScore + 1;
			}
		}

		finalScore = (finalScore/52)*100;

//		"Percentage In Exam: %.2f%%%n", percent

		return String.format("Percentage In Exam: %.2f%%%n", finalScore);
	}

}
