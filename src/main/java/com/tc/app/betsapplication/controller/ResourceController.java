package com.tc.app.betsapplication.controller;

import java.util.List;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/**
 * Rest Controller class responsible for exposing all API's related to betting
 * App
 *
 */
@RestController
@RequestMapping("/betsapp")
public class ResourceController {

	@Autowired
	BettingService bettingService;

	/**
	 * Exposing API to retrieve all bettings saved in DataBase
	 * 
	 * @return List of {@link BettingData}
	 */
	@RequestMapping(value = "/bettings", method = RequestMethod.GET)
	public List<BettingData> getAllBettingData() {

		return bettingService.getAllBettingData();
	}

	/**
	 * API responsible for saving bettings data. Input is list of
	 * {@link BettingData}, validate the parameters and save it in DB
	 * 
	 * @param bettingData list of {@link BettingData} as input to save
	 */
	@RequestMapping(value = "/bettings", method = RequestMethod.POST)
	public ResponseEntity<String> saveBettingData(@Valid @RequestBody List<BettingData> bettingData) {

		bettingData.forEach(new Consumer<BettingData>() {

			@Override
			public void accept(BettingData data) {

				bettingService.saveBettingData(data);
			}
		});
		return  ResponseEntity.status(HttpStatus.CREATED).build();
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
