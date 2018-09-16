package com.tc.app.betsapplication.controller;

import java.util.List;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tc.app.betsapplication.data.BettingData;
import com.tc.app.betsapplication.data.views.BetTypeCountView;
import com.tc.app.betsapplication.data.views.BetTypeInvestmentDataView;
import com.tc.app.betsapplication.data.views.BetsSoldHourlyView;
import com.tc.app.betsapplication.data.views.CustomerInvestmentDataView;
import com.tc.app.betsapplication.service.BettingService;

@RestController
@RequestMapping("/betsapp")
public class ResourceController {

	@Autowired
	BettingService bettingService;

	@RequestMapping(value = "/bettings", method = RequestMethod.GET)
	public List<BettingData> getAllBettingData() {

		return bettingService.getAllBettingData();
	}

	@RequestMapping(value = "/bettings", method = RequestMethod.POST)
	public void saveBettingData(@Valid @RequestBody List<BettingData> bettingData) {

		bettingData.forEach(new Consumer<BettingData>() {

			@Override
			public void accept(BettingData data) {

				bettingService.saveBettingData(data);
			}
		});
	}

	@RequestMapping(value = "/bettings/investment/bettype", method = RequestMethod.GET)
	public List<BetTypeInvestmentDataView> getInvestmentByBetType() {

		return bettingService.getInvestmentByBettingType();
	}

	@RequestMapping(value = "/bettings/investment/customer", method = RequestMethod.GET)
	public List<CustomerInvestmentDataView> getInvestmetnByCustomerId() {

		return bettingService.getTotalInvestmentByCustomerId();
	}

	@RequestMapping(value = "/bettings/betscount", method = RequestMethod.GET)
	public List<BetTypeCountView> getBetsCount() {

		return bettingService.getBetsCount();
	}

	@RequestMapping(value = "/bettings/betshourlycount", method = RequestMethod.GET)
	public List<BetsSoldHourlyView> getBetsHourlyCount() {

		return bettingService.getBetsSoldHourly();
	}

}
