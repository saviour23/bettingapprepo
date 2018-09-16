package com.tc.app.betsapplication.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.tc.app.betsapplication.data.views.BetsSoldHourlyView;

public class BetsHourlySoldMapper implements RowMapper<BetsSoldHourlyView> {

	@Override
	public BetsSoldHourlyView mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		BetsSoldHourlyView betsSoldHourlyView = new BetsSoldHourlyView();
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");
		LocalDateTime dateTimeObject = LocalDateTime.parse(rs.getString("soldDate"),dateFormatter);
		betsSoldHourlyView.setDateTime(dateTimeObject.toString());
		betsSoldHourlyView.setBetsSoldCount(Integer.parseInt(rs.getString("betsCount")));
		
		return betsSoldHourlyView;
	}

}
