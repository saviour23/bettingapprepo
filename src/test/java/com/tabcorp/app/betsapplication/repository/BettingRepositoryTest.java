package com.tabcorp.app.betsapplication.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.tabcorp.app.betsapplication.data.BettingData;
import com.tabcorp.app.betsapplication.repository.BettingRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BettingRepositoryTest {

	@Autowired
	BettingRepository bettingRepo;

	@Test
	public void testFindAll() {
		List<BettingData> listData = new ArrayList();
		bettingRepo.findAll().forEach(listData::add);
		assertThat(listData.get(0).getCustomerId()).isNotNull();

	}
	
	@Test
	public void testFind() {
		BettingData data=bettingRepo.findOne(1l);
		assertThat(data).isNotNull();

	}

}
