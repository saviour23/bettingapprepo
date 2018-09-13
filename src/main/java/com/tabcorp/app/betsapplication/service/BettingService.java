package com.tabcorp.app.betsapplication.service;

import java.util.List;

import com.tabcorp.app.betsapplication.data.BettingData;
import com.tabcorp.app.betsapplication.data.views.BetTypeCountView;
import com.tabcorp.app.betsapplication.data.views.BetTypeInvestmentDataView;
import com.tabcorp.app.betsapplication.data.views.BetsSoldHourlyView;
import com.tabcorp.app.betsapplication.data.views.CustomerInvestmentDataView;

public interface BettingService {

	List<CustomerInvestmentDataView> getTotalInvestmentByCustomerId();

	List<BetTypeCountView> getBetsCount();

	List<BettingData> getAllBettingData();

	public void saveBettingData(BettingData bettingData);

	public List<BetTypeInvestmentDataView> getInvestmentByBettingType();

	List<BetsSoldHourlyView> getBetsSoldHourly();
}
