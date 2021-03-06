package com.doug.services;

import com.doug.domain.CardInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by doug on 1/24/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CardServiceSimpleCardTest {

    @Autowired
    CardService cardService;

    ArrayList<CardInfo> masterCardList;

    @Before
    public void SetUp() {

        masterCardList = cardService.createCardLearningMasterList();

    }


    @Test
    public void getSingleCardInfoTest() throws Exception {

        CardInfo cardInfo = new CardInfo();

        cardInfo.setCardName("ace_of_spades");
        cardInfo.setActionName("action");
        cardInfo.setObjectName("object");
        cardInfo.setPersonName("person");

        CardInfo answerCard = cardService.GetCardInfoFromCardName(cardInfo.getCardName(), masterCardList);

        assertNotNull(answerCard);

    }

    @Test
    public void getCardInfo() throws Exception {
        CardInfo cardInfo = new CardInfo();

        cardInfo.setCardName("ace_of_spades");

        CardInfo answerCard = cardService.GetCardInfoFromCardName(cardInfo.getCardName(), masterCardList);

        assertEquals("ace_of_spades", answerCard.getCardName());

    }



}
