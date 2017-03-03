package com.doug.services;

import com.doug.domain.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Doug on 12/19/16.
 */

public abstract class Helpers {

	public static String EncryptInput(String inputString){
		String cryptedPassword=new BCryptPasswordEncoder().encode("ass");
		System.out.println(cryptedPassword);
		return cryptedPassword;
	}

	public static ArrayList<Card> Score(ArrayList<Card> masterDeck, ArrayList<Card> quickAnswers) {
		ArrayList testArray = new ArrayList();

		for (int i = 0; i < quickAnswers.size(); i++) {
			if (masterDeck.get(i).getCardName().equals(quickAnswers.get(i).getCardName())) {
				testArray.add(true);
				//System.out.println("Found equal on number " + i + " - " + masterDeck.get(i).getCardName() + " = " + quickAnswers.get(i).getCardName());
			} else {

				testArray.add(false);
				//System.out.println("Found not equal on number " + i + " - " + masterDeck.get(i).getCardName() + " != " +
				//		  quickAnswers.get(i).getCardName());
			}
		}
		return testArray;


	}

	public static String ResolveAnswers(String cardEntry) {
		String firstChar;
		String cardName;
		String suit = "";
		String suitCode = "";

		firstChar = ((String) cardEntry.substring(0, 1));
		suitCode = ((String) cardEntry.substring(1, 2));

		//Get cardName
		switch (firstChar) {
			case "a":
				cardName = "ace";
				break;
			case "j":
				cardName = "jack";
				break;
			case "k":
				cardName = "king";
				break;
			case "q":
				cardName = "queen";
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
				suit = "spades";
				break;
			case "h":
				suit = "hearts";
				break;
			case "c":
				suit = "clubs";
				break;
			case "d":
				suit = "diamonds";
				break;
			default:
				suit = null;
				break;
		}


		return (cardName + "_of_" + suit);

	}

	public static ArrayList SimpleCompareCardInfoArrays(ArrayList<CardInfo> masterDeck, ArrayList<SingleCardScore> answerDeck) {
		ArrayList<Test> testArray = new ArrayList();
		Test test;
		Double finalScore = 0.00;

		for (int i = 0; i < answerDeck.size(); i++) {
			test = new Test();
//			test.setId(i);
			test.setMasterCardName(masterDeck.get(i).getCardName());
			test.setAnswerCardName(answerDeck.get(i).getCardName());

			if (masterDeck.get(i).getCardName().equals(answerDeck.get(i).getCardName())) {
				test.setCorrect(true);
				finalScore = finalScore + 1;
				System.out.println("Found equal on number " + i + " - " + masterDeck.get(i).getCardName() + " = " + answerDeck.get(i).getCardName());
			} else {
				test.setCorrect(false);
				System.out.println("Found not equal on number " + i + " - " + masterDeck.get(i).getCardName() + " != " +
						  answerDeck.get(i).getCardName());
			}
			testArray.add(i, test);
		}

		return testArray;


	}


	public static ArrayList SimpleCompareLocationArrays(ArrayList<Location> masterLocationList,
																		 ArrayList<Location> locationEnteredAnswers) {
		ArrayList<TestLocation> testArray = new ArrayList();
		TestLocation test;
		Double finalScore = 0.00;




		for (int i = 0; i < masterLocationList.size(); i++) {
			test = new TestLocation();
//			test.setId(i);
			test.setMasterLocationName(masterLocationList.get(i).getLocationName());

			test.setAnswerLocationName(locationEnteredAnswers.get(i).toString());

			if (masterLocationList.get(i).getLocationName().equals(locationEnteredAnswers.get(i).toString())) {
				test.setCorrect(true);
				finalScore = finalScore + 1;
				System.out.println("Found equal on number " + i + " - " + masterLocationList.get(i).getLocationName() + " = " + locationEnteredAnswers.get(i).toString());
			} else {
				test.setCorrect(false);
				System.out.println("Found not equal on number " + i + " - " + masterLocationList.get(i).getLocationName() + " != " +
						  locationEnteredAnswers.get(i).toString());
			}
			testArray.add(i, test);
		}

		return testArray;


	}

	public static ArrayList SimpleCompareArrays(ArrayList<Card> masterDeck, ArrayList<Card> answerDeck) {
		ArrayList<Test> testArray = new ArrayList();
		Test test;
		Double finalScore = 0.00;

		for (int i = 0; i < masterDeck.size(); i++) {
			test = new Test();
//			test.setId(i);
			test.setMasterCardName(masterDeck.get(i).getCardName());
			test.setAnswerCardName(answerDeck.get(i).getCardName());

			if (masterDeck.get(i).getCardName().equals(answerDeck.get(i).getCardName())) {
				test.setCorrect(true);
				finalScore = finalScore + 1;
				System.out.println("Found equal on number " + i + " - " + masterDeck.get(i).getCardName() + " = " + answerDeck.get(i).getCardName());
			} else {
				test.setCorrect(false);
				System.out.println("Found not equal on number " + i + " - " + masterDeck.get(i).getCardName() + " != " +
						  answerDeck.get(i).getCardName());
			}
			testArray.add(i, test);
		}

		return testArray;


	}

	public static BigDecimal CalcFinalScore(ArrayList<Test> testArray) {
		Double finalScore = 0.00;

		for (int i = 0; i < testArray.size(); i++) {
			if (testArray.get(i).isCorrect()) {
				finalScore = finalScore + 1;
			}
		}

		//finalScore = (finalScore / 52) * 100;

		BigDecimal b = new BigDecimal((finalScore / 52) * 100);
		b = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		return b;
	}

	public static String makeCardString(String cardName) {

		if (cardName.indexOf(".png") == -1) {
			return cardName + ".png";
		}

		return cardName;
	}

	public static Card makeCard(String cardName) {

		if (cardName.indexOf(".png") == -1) {
			Card card = new Card();
			card.setCardName(cardName + ".png");
			return card;
		}

		return null;
	}

	public static CardInfo getCardInfoFromCardName(String cardName, ArrayList<CardInfo> masterCardList) {

		for (int i = 0; i < masterCardList.size(); i++) {
			if (cardName.equals(masterCardList.get(i).getCardName())) {
				CardInfo cardInfo = new CardInfo();
				cardInfo.setCardName(cardName);
				cardInfo.setPersonName(masterCardList.get(i).getPersonName());
				cardInfo.setActionName(masterCardList.get(i).getActionName());
				cardInfo.setObjectName(masterCardList.get(i).getObjectName());
				return cardInfo;
			}
		}
//		TODO: throw cardNotFoundException
		return null;
	}

	public static String heyAnswerListSmallx(HttpSession session) {


		Object mycard = session.getAttribute("answer");
		String hey = "hey";

		return hey;

	}

}
