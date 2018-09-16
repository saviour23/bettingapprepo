package com.tc.app.betsapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.tc.app.betsapplication.data.BettingData;
import com.tc.app.betsapplication.data.mapper.BetTypeMapper;
import com.tc.app.betsapplication.data.mapper.BetsCountMapper;
import com.tc.app.betsapplication.data.mapper.BetsHourlySoldMapper;
import com.tc.app.betsapplication.data.mapper.CustomerTotalInvestmentMapper;
import com.tc.app.betsapplication.data.views.BetTypeCountView;
import com.tc.app.betsapplication.data.views.BetTypeInvestmentDataView;
import com.tc.app.betsapplication.data.views.BetsSoldHourlyView;
import com.tc.app.betsapplication.data.views.CustomerInvestmentDataView;
import com.tc.app.betsapplication.repository.BettingRepository;
import com.tc.app.betsapplication.service.BettingService;
import com.tc.app.betsapplication.util.DataProvisioner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BettingServiceImplTest {
	// @Autowired
	// private TestEntityManager entityManager;

	@Autowired
	BettingService bettingService;
	@MockBean
	BettingRepository bettingRepo;

	@MockBean
	JdbcTemplate jdbcTemplate;

	@Before
	public void init() {

		DataProvisioner.provisionInitialData(bettingService);
	}

	@Test
	public void testGetAllBettingData() {
		BettingData data = new BettingData();
		List<BettingData> listData = new ArrayList<>();
		listData.add(data);
		data.setCustomerId("dummy");
		Mockito.when(bettingRepo.findAll()).thenReturn(listData);
		List<BettingData> data1 = bettingService.getAllBettingData();
		assertThat(data1.get(0).getCustomerId()).isEqualTo("dummy");

	}

	@Test
	public void testTotalInvestmentByCustomerId() {
		String customerId = "dummy";
		CustomerInvestmentDataView investmentObject = new CustomerInvestmentDataView();
		investmentObject.setCustomerId(customerId);

		List<CustomerInvestmentDataView> customerInvestmentDatas = new ArrayList<>();
		customerInvestmentDatas.add(investmentObject);
		Mockito.when(jdbcTemplate.query(anyString(), any(CustomerTotalInvestmentMapper.class)))
				.thenReturn(customerInvestmentDatas);
		List<CustomerInvestmentDataView> data = bettingService.getTotalInvestmentByCustomerId();
		assertThat(data.get(0).getCustomerId()).isEqualTo(customerId);

	}

	@Test
	public void testSaveBettingData() {
		BetTypeInvestmentDataView investmentObject = new BetTypeInvestmentDataView();
		investmentObject.setInvestmentAmount(BigDecimal.TEN);

		List<BetTypeInvestmentDataView> investList = new ArrayList<>();
		investList.add(investmentObject);
		Mockito.when(jdbcTemplate.query(anyString(), any(BetTypeMapper.class))).thenReturn(investList);
		List<BetTypeInvestmentDataView> data = bettingService.getInvestmentByBettingType();
		assertThat(data.get(0).getInvestmentAmount()).isEqualTo(BigDecimal.TEN);

	}

	@Test
	public void testGetBetsCount() {

		List<BetTypeCountView> betTypeCountDataList = new ArrayList<>();
		BetTypeCountView countView = new BetTypeCountView();
		countView.setCount(100);
		betTypeCountDataList.add(countView);

		Mockito.when(jdbcTemplate.query(anyString(), any(BetsCountMapper.class))).thenReturn(betTypeCountDataList);
		List<BetTypeCountView> betsCount = bettingService.getBetsCount();
		assertThat(betsCount).isNotNull();
		assertThat(betsCount.get(0).getCount()).isEqualTo(100);
	}

	@Test
	public void testBetsSoldHourly() {

		List<BetsSoldHourlyView> betsSoldHourlyList = new ArrayList<>();
		BetsSoldHourlyView countView = new BetsSoldHourlyView();
		countView.setBetsSoldCount(200);
		betsSoldHourlyList.add(countView);

		Mockito.when(jdbcTemplate.query(anyString(), any(BetsHourlySoldMapper.class))).thenReturn(betsSoldHourlyList);
		List<BetsSoldHourlyView> betsCount = bettingService.getBetsSoldHourly();
		assertThat(betsCount).isNotNull();
		assertThat(betsCount.get(0).getBetsSoldCount()).isEqualTo(200);
	}

}
