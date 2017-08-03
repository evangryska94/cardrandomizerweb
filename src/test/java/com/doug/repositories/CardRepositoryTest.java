package com.doug.repositories;

import com.doug.domain.CardInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Doug on 2/18/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CardRepositoryTest {

	@Autowired
	CardRepository cardRepository;


	@Test
	public void getCardNameLike() {
		List<CardInfo> myCardList = cardRepository.findByCardNameLike("%diam%");
		Assert.assertEquals(13, myCardList.size());
	}
}