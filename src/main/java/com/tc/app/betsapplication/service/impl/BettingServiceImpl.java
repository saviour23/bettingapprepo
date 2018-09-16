package com.tc.app.betsapplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
import com.tc.app.betsapplication.repository.UserRepository;
import com.tc.app.betsapplication.service.BettingService;

@Service
public class BettingServiceImpl implements BettingService {

	@Autowired
	BettingRepository bettingRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserRepository userRepo;

	@Override
	public List<CustomerInvestmentDataView> getTotalInvestmentByCustomerId() {

		List<CustomerInvestmentDataView> customerInvestmentDatas = jdbcTemplate.query(
				"SELECT a.customer_id as customerId, a.SUM(investment) as investment FROM betting_data a group by customer_id",
				new CustomerTotalInvestmentMapper());
		return customerInvestmentDatas;
	}

	@Override
	public List<BettingData> getAllBettingData() {

		List<BettingData> bettingList = new ArrayList<>();
		bettingRepo.findAll().forEach(bettingList::add);
		return bettingList;
	}

	@Override
	public void saveBettingData(BettingData bettingData) {
		bettingRepo.save(bettingData);

	}

	@Override
	public List<BetTypeInvestmentDataView> getInvestmentByBettingType() {

		List<BetTypeInvestmentDataView> betTypeInvestmentDatas = jdbcTemplate.query(
				"SELECT a.bet_type as betType, a.SUM(investment) as investment FROM betting_data a group by bet_type",
				new BetTypeMapper());
		return betTypeInvestmentDatas;
	}

	@Override
	public List<BetTypeCountView> getBetsCount() {

		List<BetTypeCountView> betTypeCountData = jdbcTemplate.query(
				"SELECT a.bet_type as betType, a.COUNT(bet_type) as betcount FROM betting_data a group by bet_type",
				new BetsCountMapper());
		return betTypeCountData;

	}

	@Override
	public List<BetsSoldHourlyView> getBetsSoldHourly() {
		List<BetsSoldHourlyView> betsSoldHourlyList = jdbcTemplate.query(
				"SELECT TO_CHAR(t.DATE_TIME, 'DD-MM-YYYY HH24') AS soldDate, COUNT(*) AS betsCount\n"
						+ "    FROM BETTING_DATA t\n" + "GROUP BY TO_CHAR(t.DATE_TIME, 'DD-MM-YYYY HH24')",
				new BetsHourlySoldMapper());
		return betsSoldHourlyList;
	}

}
