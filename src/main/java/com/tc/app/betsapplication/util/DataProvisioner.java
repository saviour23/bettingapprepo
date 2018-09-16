package com.tc.app.betsapplication.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tc.app.betsapplication.data.BetType;
import com.tc.app.betsapplication.data.BettingData;
import com.tc.app.betsapplication.service.BettingService;

/**
 * 
 * Initial test data provisioner
 *
 */
public class DataProvisioner {

	
	public static void provisionInitialData(BettingService bettingService) {
		
		BettingData bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("123");
		bettingData.setCustomerId("customer1");
		bettingData.setBetType(BetType.WIN);
		bettingData.setDateTime(LocalDateTime.now());
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer2");
		bettingData.setBetType(BetType.PLACE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(1));
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer3");
		bettingData.setBetType(BetType.PLACE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(2));
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer4");
		bettingData.setBetType(BetType.QUADDIE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(3));
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer5");
		bettingData.setBetType(BetType.QUADDIE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(3));
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer6");
		bettingData.setBetType(BetType.PLACE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(2));
		bettingService.saveBettingData(bettingData);

		bettingData = new BettingData();
		bettingData.setInvestment(BigDecimal.TEN);
		bettingData.setPropNumber("1233");
		bettingData.setCustomerId("customer7");
		bettingData.setBetType(BetType.PLACE);
		bettingData.setDateTime(LocalDateTime.now().minusHours(2));
		bettingService.saveBettingData(bettingData);

	}
}
