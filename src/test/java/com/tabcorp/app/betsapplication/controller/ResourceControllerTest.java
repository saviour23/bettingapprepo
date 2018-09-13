package com.tabcorp.app.betsapplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tabcorp.app.betsapplication.data.BetType;
import com.tabcorp.app.betsapplication.data.BettingData;
import com.tabcorp.app.betsapplication.data.views.BetTypeCountView;
import com.tabcorp.app.betsapplication.data.views.BetTypeInvestmentDataView;
import com.tabcorp.app.betsapplication.data.views.BetsSoldHourlyView;
import com.tabcorp.app.betsapplication.data.views.CustomerInvestmentDataView;
import com.tabcorp.app.betsapplication.service.BettingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceControllerTest {

	@Autowired
	ResourceController controller;

	@MockBean
	BettingService bettingService;

	
	@Test
	public void testGetInvestmentByBetType() {
		List<BetTypeInvestmentDataView> viewList = new ArrayList<BetTypeInvestmentDataView>();
		BetTypeInvestmentDataView dummyObj = new BetTypeInvestmentDataView();
		dummyObj.setInvestmentAmount(BigDecimal.TEN);
		dummyObj.setBetType(BetType.QUADDIE);
		viewList.add(dummyObj);
		Mockito.when(bettingService.getInvestmentByBettingType()).thenReturn(viewList);
		List<BetTypeInvestmentDataView> returnList = controller.getInvestmentByBetType();
		assertThat(returnList.get(0).getInvestmentAmount()).isEqualTo(BigDecimal.TEN);
		assertThat(returnList.get(0).getBetType()).isEqualTo(BetType.QUADDIE);

	}

	@Test
	public void testGetInvestmetnByCustomerId() {
		String customerId = "dummyCustomer";
		List<CustomerInvestmentDataView> viewList = new ArrayList<>();
		CustomerInvestmentDataView dummyObj = new CustomerInvestmentDataView();
		dummyObj.setCustomerId(customerId);
		dummyObj.setTotalInvestment(BigDecimal.TEN);
		viewList.add(dummyObj);
		Mockito.when(bettingService.getTotalInvestmentByCustomerId()).thenReturn(viewList);
		List<CustomerInvestmentDataView> returnList = controller.getInvestmetnByCustomerId();
		assertThat(returnList.get(0).getTotalInvestment()).isEqualTo(BigDecimal.TEN);

		assertThat(returnList.get(0).getCustomerId()).isEqualTo(customerId);}

	@Test
	public void testGetBetsCount() {

		List<BetTypeCountView> viewList = new ArrayList<>();
		BetTypeCountView dummyObj = new BetTypeCountView();
		dummyObj.setBetType(BetType.DOUBLE);
		viewList.add(dummyObj);
		Mockito.when(bettingService.getBetsCount()).thenReturn(viewList);
		List<BetTypeCountView> returnList = controller.getBetsCount();
		assertThat(returnList.get(0).getBetType()).isEqualTo(BetType.DOUBLE);

	}

	@Test
	public void testSaveBettingData() {
		BettingData bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("123");
		bettingData.setCustomerId("customer1");
		bettingData.setBetType(BetType.WIN);
		bettingData.setDateTime(LocalDateTime.now());
		List<BettingData> viewList = new ArrayList<>();
		viewList.add(bettingData);
		doNothing().when(bettingService).saveBettingData(bettingData);
		controller.saveBettingData(viewList);

	}

	@Test
	public void testGetBetsHourlyCount() {
		List<BetsSoldHourlyView> viewList = new ArrayList();
		BetsSoldHourlyView dummyObj = new BetsSoldHourlyView();
		dummyObj.setBetsSoldCount(100);
		dummyObj.setDateTime("date");
		viewList.add(dummyObj);
		Mockito.when(bettingService.getBetsSoldHourly()).thenReturn(viewList);

		List<BetsSoldHourlyView> returnList = controller.getBetsHourlyCount();
		assertThat(returnList.get(0).getBetsSoldCount()).isEqualTo(100);
		assertThat(returnList.get(0).getDateTime()).isEqualTo("date");

	}

	@Test
	public void testgetAllBettingData() {
		BettingData bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("123");

		bettingData.setCustomerId("customer1");
		bettingData.setBetType(BetType.WIN);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime date = LocalDateTime.parse("10-10-2018 18:10", formatter);
		bettingData.setDateTime(date);

		List<BettingData> viewList = new ArrayList<>();
		viewList.add(bettingData);
		Mockito.when(bettingService.getAllBettingData()).thenReturn(viewList);
		List<BettingData> returnList = controller.getAllBettingData();
		assertThat(returnList.get(0).getInvestment()).isEqualTo(BigDecimal.TEN);
		assertThat(returnList.get(0).getBetType()).isEqualTo(BetType.WIN);
		assertThat(returnList.get(0).getPropNumber()).isEqualTo("123");
		assertThat(returnList.get(0).getDateTime()).isEqualTo(date);

	}

}
